/*
 * Entagged Audio Tag library
 * Copyright (c) 2003-2005 Rapha�l Slinckx <raphael@slinckx.net>
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *  
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.jaudiotagger.audio.mp4.util;

import org.jaudiotagger.audio.generic.Utils;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Logger;

/**
 * Everything in MP4s are held in boxes (formally known as atoms), they are held as a hierachial tree within the MP4.
 * <p/>
 * We are most interested in boxes that are used to hold metadata, but we have to know about some other boxes
 * as well in order to find them.
 * <p/>
 * All boxes consist of a 4 byte box length (big Endian), and then a 4 byte identifier, this is the header
 * which is model in this class.
 * <p/>
 * The length includes the length of the box including the identifier and the length itself.
 * Then they may contain data and/or sub boxes, if they contain subboxes they are known as a parent box. Parent boxes
 * shouldn't really contain data, but sometimes they do.
 * <p/>
 * Parent boxes length includes the length of their immediate sub boxes
 * <p/>
 * This class is normally used by instantiating with the empty constructor, then use the update method
 * to pass the header data which is used to read the identifier and the the size of the box
 */
public class Mp4BoxHeader
{
// Logger Object
public static Logger logger = Logger.getLogger("org.jaudiotagger.audio.mp4.util");

    public static final int OFFSET_POS = 0;
    public static final int IDENTIFIER_POS = 4;
    public static final int OFFSET_LENGTH = 4;
    public static final int IDENTIFIER_LENGTH = 4;
    public static final int HEADER_LENGTH = OFFSET_LENGTH + IDENTIFIER_LENGTH;

    //Box identifier
    private String id;

    //Box length
    private int length;

    //Raw Data includes header and body
    private byte[] rawdata;

    /**
     * Construct empty header
     *
     * Can be populated later with update method
     */
    public Mp4BoxHeader()
    {

    }

    /**
     * Construct header
     *
     * Create header using headerdata, expected to find header at headerdata current position
     *
     * Note after processing adjusts position to immediately after header
     *
     * @param headerData
     */
    public Mp4BoxHeader(ByteBuffer headerData)
    {
        update(headerData);
    }

    /**
     * Create header using headerdata, expected to find header at headerdata current position
     *
     * Note after processing adjusts position to immediately after header
     *
     * @param headerData
     */
    public void update(ByteBuffer headerData)
    {
        //Read header data into byte array
        byte[] b = new byte[HEADER_LENGTH];
        headerData.get(b);

        //Calculate box size
        this.length = Utils.getNumberBigEndian(b, OFFSET_POS, OFFSET_LENGTH - 1);

        //Calculate box id
        this.id = Utils.getString(b, IDENTIFIER_POS, IDENTIFIER_LENGTH);

        logger.info("Read header:"+id+":length:"+length);

    }

    /**
     *
     * @return the box identifier
     */
    public String getId()
    {
        return id;
    }

    /**
     *
     * @return the length of the boxs data (ncludes the header size)
     */
    public int getLength()
    {
        return length;
    }

    /**
     *
     * @return the length of the data
     */
    public int getDataLength()
    {
        return length - HEADER_LENGTH;
    }

    public String toString()
    {
        return "Box " + id + ":" + length;
    }

    public byte[] getRawdata()
    {
        return rawdata;
    }

    public String getEncoding()
    {
        return "ISO-8859-1";
    }


    /**
     * Seek for box with the specified id starting from the current location of filepointer,
     * <p/>
     * Note it wont find the box if it is contained with a level below the current level, nor if we are
     * at a parent atom that also contains data and we havent yet processed the data. It will work
     * if we are at the start of a child box even if it not the required box as long as the box we are
     * looking for is the same level.
     *
     * @param raf
     * @param id
     * @throws java.io.IOException
     */
    public static Mp4BoxHeader seekWithinLevel(RandomAccessFile raf, String id) throws IOException
    {
        Mp4BoxHeader boxHeader = new Mp4BoxHeader();
        ByteBuffer   headerBuffer = ByteBuffer.allocate(HEADER_LENGTH);
        raf.getChannel().read(headerBuffer);
        headerBuffer.rewind();
        boxHeader.update(headerBuffer);
        while (!boxHeader.getId().equals(id))
        {
            raf.skipBytes(boxHeader.getLength() - HEADER_LENGTH);
            headerBuffer.rewind();
            raf.getChannel().read(headerBuffer);
            headerBuffer.rewind();
            boxHeader.update(headerBuffer);
        }
        return boxHeader;
    }

    public static Mp4BoxHeader seekWithinLevel(ByteBuffer data, String id) throws IOException
    {
        Mp4BoxHeader boxHeader = new Mp4BoxHeader();
        boxHeader.update(data);
        while (!boxHeader.getId().equals(id))
        {
            data.position(data.position() + (boxHeader.getLength() - HEADER_LENGTH));
            boxHeader.update(data);
        }
        return boxHeader;
    }
}
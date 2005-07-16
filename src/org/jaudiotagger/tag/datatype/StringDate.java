/**
 *  Amended @author : Paul Taylor
 *  Initial @author : Eric Farng
 *
 *  Version @version:$Id$
 *
 *  MusicTag Copyright (C)2003,2004
 *
 *  This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser
 *  General Public  License as published by the Free Software Foundation; either version 2.1 of the License,
 *  or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 *  the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *  See the GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License along with this library; if not,
 *  you can get a copy from http://www.opensource.org/licenses/lgpl-license.php or write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 * Description:
 *
 */
package org.jaudiotagger.tag.datatype;

import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.audio.mp3.*;
import org.jaudiotagger.tag.id3.ID3Tags;
import org.jaudiotagger.tag.AbstractTagFrameBody;
import org.jaudiotagger.tag.id3.ID3Tags;

public class StringDate extends StringFixedLength
{
    /**
     * Creates a new ObjectStringDate datatype.
     *
     * @param identifier DOCUMENT ME!
     */
    public StringDate(String identifier, AbstractTagFrameBody frameBody)
    {
        super(identifier, frameBody, 8);
    }

    public StringDate(StringDate object)
    {
        super(object);
    }

    /**
     * DOCUMENT ME!
     *
     * @param value DOCUMENT ME!
     */
    public void setValue(Object value)
    {
        if (value != null)
        {
            this.value = ID3Tags.stripChar(value.toString(), '-');
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Object getValue()
    {
        if (value != null)
        {
            return ID3Tags.stripChar(value.toString(), '-');
        }
        else
        {
            return null;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof StringDate == false)
        {
            return false;
        }

        return super.equals(obj);
    }
}
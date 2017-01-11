/*
 * Entagged Audio Tag library
 * Copyright (c) 2003-2005 Raphaël Slinckx <raphael@slinckx.net>
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
package ealvatag.audio.generic;

import ealvatag.audio.AudioFile;
import ealvatag.audio.exceptions.CannotReadException;
import ealvatag.audio.exceptions.InvalidAudioFrameException;
import ealvatag.audio.exceptions.NoReadPermissionsException;
import ealvatag.audio.exceptions.ReadOnlyFileException;
import ealvatag.logging.ErrorMessage;
import ealvatag.tag.Tag;
import ealvatag.tag.TagException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * This abstract class is the skeleton for tag readers. It handles the creation/closing of
 * the randomaccessfile objects and then call the subclass method getEncodingInfo and getTag.
 * These two method have to be implemented in the subclass.
 *
 *@author	Raphael Slinckx
 *@version	$Id$
 *@since	v0.02
 */

public abstract class AudioFileReader {

    // Logger Object
    private static Logger LOG = LoggerFactory.getLogger(AudioFileReader.class);
    protected static final int MINIMUM_SIZE_FOR_VALID_AUDIO_FILE = 100;

    /*
    * Returns the encoding info object associated wih the current File.
    * The subclass can assume the RAF pointer is at the first byte of the file.
    * The RandomAccessFile must be kept open after this function, but can point
    * at any offset in the file.
    *
    * @param raf The RandomAccessFile associtaed with the current file
    * @exception IOException is thrown when the RandomAccessFile operations throw it (you should never throw them
    * manually)
    * @exception CannotReadException when an error occured during the parsing of the encoding infos
    */
    protected abstract GenericAudioHeader getEncodingInfo(RandomAccessFile raf) throws CannotReadException, IOException;


    /*
      * Same as above but returns the Tag contained in the file, or a new one.
      *
      * @param raf The RandomAccessFile associted with the current file
      * @exception IOException is thrown when the RandomAccessFile operations throw it (you should never throw them
      * manually)
      * @exception CannotReadException when an error occured during the parsing of the tag
      */
    protected abstract Tag getTag(RandomAccessFile raf) throws CannotReadException, IOException;

    /*
      * Reads the given file, and return an AudioFile object containing the Tag
      * and the encoding infos present in the file. If the file has no tag, an
      * empty one is returned. If the encodinginfo is not valid , an exception is thrown.
      *
      * @param f The file to read
      * @exception CannotReadException If anything went bad during the read of this file
      */
    public AudioFile read(File f) throws CannotReadException, IOException, TagException, ReadOnlyFileException,
                                         InvalidAudioFrameException {
        LOG.trace(ErrorMessage.GENERAL_READ.getMsg(f.getAbsolutePath()));

        if (!f.canRead()) {
            LOG.error(ErrorMessage.GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE.getMsg(f.getAbsolutePath()));
            throw new NoReadPermissionsException(ErrorMessage.GENERAL_READ_FAILED_DO_NOT_HAVE_PERMISSION_TO_READ_FILE
                                                         .getMsg(f.getAbsolutePath()));
        }

        if (f.length() <= MINIMUM_SIZE_FOR_VALID_AUDIO_FILE) {
            throw new CannotReadException(ErrorMessage.GENERAL_READ_FAILED_FILE_TOO_SMALL.getMsg(f.getAbsolutePath()));
        }

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(f, "r");
            raf.seek(0);

            GenericAudioHeader info = getEncodingInfo(raf);
            raf.seek(0);
            Tag tag = getTag(raf);
            return new AudioFile(f, info, tag);

        } catch (CannotReadException cre) {
            throw cre;
        } catch (Exception e) {
            LOG.error(ErrorMessage.GENERAL_READ.getMsg(f.getAbsolutePath()), e);
            throw new CannotReadException(f.getAbsolutePath() + ":" + e.getMessage(), e);
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (Exception ex) {
                LOG.warn(ErrorMessage.GENERAL_READ_FAILED_UNABLE_TO_CLOSE_RANDOM_ACCESS_FILE
                                 .getMsg(f.getAbsolutePath()));
            }
        }
    }
}

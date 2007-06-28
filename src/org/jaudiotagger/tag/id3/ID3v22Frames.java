/*
 * Jaudiotagger Copyright (C)2004,2005
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public  License as published by the Free Software Foundation; either version 2.1 of the License,
 * or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library; if not,
 * you can get a copy from http://www.opensource.org/licenses/lgpl-license.php or write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package org.jaudiotagger.tag.id3;

/**
 * Defines ID3v22 frames and collections that categorise frames within an ID3v22 tag.
 * <p/>
 * You can include frames here that are not officially supported as long as they can be used within an
 * ID3v22Tag
 *
 * @author Paul Taylor
 * @version $Id$
 */
public class ID3v22Frames extends ID3Frames
{
    //V2 Frames (only 3 chars)
    public static final String FRAME_ID_V2_ACCOMPANIMENT = "TP2";
    public static final String FRAME_ID_V2_ALBUM = "TAL";
    public static final String FRAME_ID_V2_ARTIST = "TP1";
    public static final String FRAME_ID_V2_ATTACHED_PICTURE = "PIC";
    public static final String FRAME_ID_V2_AUDIO_ENCRYPTION = "CRA";
    public static final String FRAME_ID_V2_BPM = "TBP";
    public static final String FRAME_ID_V2_COMMENT = "COM";
    public static final String FRAME_ID_V2_COMPOSER = "TCM";
    public static final String FRAME_ID_V2_CONDUCTOR = "TPE";
    public static final String FRAME_ID_V2_CONTENT_GROUP_DESC = "TT1";
    public static final String FRAME_ID_V2_COPYRIGHTINFO = "TCR";
    public static final String FRAME_ID_V2_ENCODEDBY = "TEN";
    public static final String FRAME_ID_V2_ENCRYPTED_FRAME = "CRM";
    public static final String FRAME_ID_V2_EQUALISATION = "EQU";
    public static final String FRAME_ID_V2_EVENT_TIMING_CODES = "ETC";
    public static final String FRAME_ID_V2_FILE_TYPE = "TFT";
    public static final String FRAME_ID_V2_GENERAL_ENCAPS_OBJECT = "GEO";
    public static final String FRAME_ID_V2_GENRE = "TCO";
    public static final String FRAME_ID_V2_HW_SW_SETTINGS = "TSS";
    public static final String FRAME_ID_V2_INITIAL_KEY = "TKE";
    public static final String FRAME_ID_V2_IPLS = "IPL";
    public static final String FRAME_ID_V2_ISRC = "TRC";
    public static final String FRAME_ID_V2_LANGUAGE = "TLA";
    public static final String FRAME_ID_V2_LENGTH = "TLE";
    public static final String FRAME_ID_V2_LINKED_INFO = "LNK";
    public static final String FRAME_ID_V2_LYRICIST = "TXT";
    public static final String FRAME_ID_V2_MEDIA_TYPE = "TMT";
    public static final String FRAME_ID_V2_MPEG_LOCATION_LOOKUP_TABLE = "MLL";
    public static final String FRAME_ID_V2_MUSIC_CD_ID = "MCI";
    public static final String FRAME_ID_V2_ORIGARTIST = "TOA";
    public static final String FRAME_ID_V2_ORIG_FILENAME = "TOF";
    public static final String FRAME_ID_V2_ORIG_LYRICIST = "TOL";
    public static final String FRAME_ID_V2_ORIG_TITLE = "TOT";
    public static final String FRAME_ID_V2_PLAYLIST_DELAY = "TDY";
    public static final String FRAME_ID_V2_PLAY_COUNTER = "CNT";
    public static final String FRAME_ID_V2_POPULARIMETER = "POP";
    public static final String FRAME_ID_V2_PUBLISHER = "TPB";
    public static final String FRAME_ID_V2_RECOMMENDED_BUFFER_SIZE = "BUF";
    public static final String FRAME_ID_V2_RELATIVE_VOLUME_ADJUSTMENT = "RVA";
    public static final String FRAME_ID_V2_REMIXED = "TP4";
    public static final String FRAME_ID_V2_REVERB = "REV";
    public static final String FRAME_ID_V2_SET = "TPA";
    public static final String FRAME_ID_V2_SYNC_LYRIC = "SLT";
    public static final String FRAME_ID_V2_SYNC_TEMPO = "STC";
    public static final String FRAME_ID_V2_TDAT = "TDA";
    public static final String FRAME_ID_V2_TIME = "TIM";
    public static final String FRAME_ID_V2_TITLE = "TT2";
    public static final String FRAME_ID_V2_TITLE_REFINEMENT = "TT3";
    public static final String FRAME_ID_V2_TORY = "TOR";
    public static final String FRAME_ID_V2_TRACK = "TRK";
    public static final String FRAME_ID_V2_TRDA = "TRD";
    public static final String FRAME_ID_V2_TSIZ = "TSI";
    public static final String FRAME_ID_V2_TYER = "TYE";
    public static final String FRAME_ID_V2_UNIQUE_FILE_ID = "UFI";
    public static final String FRAME_ID_V2_UNSYNC_LYRICS = "ULT";
    public static final String FRAME_ID_V2_URL_ARTIST_WEB = "WAR";
    public static final String FRAME_ID_V2_URL_COMMERCIAL = "WCM";
    public static final String FRAME_ID_V2_URL_COPYRIGHT = "WCP";
    public static final String FRAME_ID_V2_URL_FILE_WEB = "WAF";
    public static final String FRAME_ID_V2_URL_OFFICIAL_RADIO = "WRS";
    public static final String FRAME_ID_V2_URL_PAYMENT = "WPAY";
    public static final String FRAME_ID_V2_URL_PUBLISHERS = "WPB";
    public static final String FRAME_ID_V2_URL_SOURCE_WEB = "WAS";
    public static final String FRAME_ID_V2_USER_DEFINED_INFO = "TXX";
    public static final String FRAME_ID_V2_USER_DEFINED_URL = "WXX";

    public static final String FRAME_ID_V2_IS_COMPILATION = "TCP";
    public static final String FRAME_ID_V2_TITLE_SORT_ORDER_ITUNES = "TST";
    public static final String FRAME_ID_V2_ARTIST_SORT_ORDER_ITUNES = "TSP";
    public static final String FRAME_ID_V2_ALBUM_SORT_ORDER_ITUNES = "TSA";


    private static ID3v22Frames id3v22Frames;

    public static ID3v22Frames getInstanceOf()
    {
        if (id3v22Frames == null)
        {
            id3v22Frames = new ID3v22Frames();
        }
        return id3v22Frames;
    }

    private ID3v22Frames()
    {
        // The defined v22 frames
        supportedFrames.add(FRAME_ID_V2_ACCOMPANIMENT);
        supportedFrames.add(FRAME_ID_V2_ALBUM);
        supportedFrames.add(FRAME_ID_V2_ARTIST);
        supportedFrames.add(FRAME_ID_V2_ATTACHED_PICTURE);
        supportedFrames.add(FRAME_ID_V2_AUDIO_ENCRYPTION);
        supportedFrames.add(FRAME_ID_V2_BPM);
        supportedFrames.add(FRAME_ID_V2_COMMENT);
        supportedFrames.add(FRAME_ID_V2_COMPOSER);
        supportedFrames.add(FRAME_ID_V2_CONDUCTOR);
        supportedFrames.add(FRAME_ID_V2_CONTENT_GROUP_DESC);
        supportedFrames.add(FRAME_ID_V2_COPYRIGHTINFO);
        supportedFrames.add(FRAME_ID_V2_ENCODEDBY);
        supportedFrames.add(FRAME_ID_V2_ENCRYPTED_FRAME);
        supportedFrames.add(FRAME_ID_V2_EQUALISATION);
        supportedFrames.add(FRAME_ID_V2_EVENT_TIMING_CODES);
        supportedFrames.add(FRAME_ID_V2_FILE_TYPE);
        supportedFrames.add(FRAME_ID_V2_GENERAL_ENCAPS_OBJECT);
        supportedFrames.add(FRAME_ID_V2_GENRE);
        supportedFrames.add(FRAME_ID_V2_HW_SW_SETTINGS);
        supportedFrames.add(FRAME_ID_V2_INITIAL_KEY);
        supportedFrames.add(FRAME_ID_V2_IPLS);
        supportedFrames.add(FRAME_ID_V2_ISRC);
        supportedFrames.add(FRAME_ID_V2_LANGUAGE);
        supportedFrames.add(FRAME_ID_V2_LENGTH);
        supportedFrames.add(FRAME_ID_V2_LINKED_INFO);
        supportedFrames.add(FRAME_ID_V2_LYRICIST);
        supportedFrames.add(FRAME_ID_V2_MEDIA_TYPE);
        supportedFrames.add(FRAME_ID_V2_MPEG_LOCATION_LOOKUP_TABLE);
        supportedFrames.add(FRAME_ID_V2_MUSIC_CD_ID);
        supportedFrames.add(FRAME_ID_V2_ORIGARTIST);
        supportedFrames.add(FRAME_ID_V2_ORIG_FILENAME);
        supportedFrames.add(FRAME_ID_V2_ORIG_LYRICIST);
        supportedFrames.add(FRAME_ID_V2_ORIG_TITLE);
        supportedFrames.add(FRAME_ID_V2_PLAYLIST_DELAY);
        supportedFrames.add(FRAME_ID_V2_PLAY_COUNTER);
        supportedFrames.add(FRAME_ID_V2_POPULARIMETER);
        supportedFrames.add(FRAME_ID_V2_PUBLISHER);
        supportedFrames.add(FRAME_ID_V2_RECOMMENDED_BUFFER_SIZE);
        supportedFrames.add(FRAME_ID_V2_RELATIVE_VOLUME_ADJUSTMENT);
        supportedFrames.add(FRAME_ID_V2_REMIXED);
        supportedFrames.add(FRAME_ID_V2_REVERB);
        supportedFrames.add(FRAME_ID_V2_SET);
        supportedFrames.add(FRAME_ID_V2_SYNC_LYRIC);
        supportedFrames.add(FRAME_ID_V2_SYNC_TEMPO);
        supportedFrames.add(FRAME_ID_V2_TDAT);
        supportedFrames.add(FRAME_ID_V2_TIME);
        supportedFrames.add(FRAME_ID_V2_TITLE);
        supportedFrames.add(FRAME_ID_V2_TITLE_REFINEMENT);
        supportedFrames.add(FRAME_ID_V2_TORY);
        supportedFrames.add(FRAME_ID_V2_TRACK);
        supportedFrames.add(FRAME_ID_V2_TRDA);
        supportedFrames.add(FRAME_ID_V2_TSIZ);
        supportedFrames.add(FRAME_ID_V2_TYER);
        supportedFrames.add(FRAME_ID_V2_UNIQUE_FILE_ID);
        supportedFrames.add(FRAME_ID_V2_UNSYNC_LYRICS);
        supportedFrames.add(FRAME_ID_V2_URL_ARTIST_WEB);
        supportedFrames.add(FRAME_ID_V2_URL_COMMERCIAL);
        supportedFrames.add(FRAME_ID_V2_URL_COPYRIGHT);
        supportedFrames.add(FRAME_ID_V2_URL_FILE_WEB);
        supportedFrames.add(FRAME_ID_V2_URL_OFFICIAL_RADIO);
        supportedFrames.add(FRAME_ID_V2_URL_PAYMENT);
        supportedFrames.add(FRAME_ID_V2_URL_PUBLISHERS);
        supportedFrames.add(FRAME_ID_V2_URL_SOURCE_WEB);
        supportedFrames.add(FRAME_ID_V2_USER_DEFINED_INFO);
        supportedFrames.add(FRAME_ID_V2_USER_DEFINED_URL);

        //Extension
        extensionFrames.add(FRAME_ID_V2_IS_COMPILATION);
        extensionFrames.add(FRAME_ID_V2_TITLE_SORT_ORDER_ITUNES);
        extensionFrames.add(FRAME_ID_V2_ARTIST_SORT_ORDER_ITUNES);
        extensionFrames.add(FRAME_ID_V2_ALBUM_SORT_ORDER_ITUNES);

        // Map frameid to a name
        idToValue.put(FRAME_ID_V2_ACCOMPANIMENT, "Text: Band/Orchestra/Accompaniment");
        idToValue.put(FRAME_ID_V2_ALBUM, "Text: Album/Movie/Show title");
        idToValue.put(FRAME_ID_V2_ARTIST, "Text: Lead artist(s)/Lead performer(s)/Soloist(s)/Performing group");
        idToValue.put(FRAME_ID_V2_ATTACHED_PICTURE, "Attached picture");
        idToValue.put(FRAME_ID_V2_AUDIO_ENCRYPTION, "Audio encryption");
        idToValue.put(FRAME_ID_V2_BPM, "Text: BPM (Beats Per Minute)");
        idToValue.put(FRAME_ID_V2_COMMENT, "Comments");
        idToValue.put(FRAME_ID_V2_COMPOSER, "Text: Composer");
        idToValue.put(FRAME_ID_V2_CONDUCTOR, "Text: Conductor/Performer refinement");
        idToValue.put(FRAME_ID_V2_CONTENT_GROUP_DESC, "Text: Content group description");
        idToValue.put(FRAME_ID_V2_COPYRIGHTINFO, "Text: Copyright message");
        idToValue.put(FRAME_ID_V2_ENCODEDBY, "Text: Encoded by");
        idToValue.put(FRAME_ID_V2_ENCRYPTED_FRAME, "Encrypted meta frame");
        idToValue.put(FRAME_ID_V2_EQUALISATION, "Equalization");
        idToValue.put(FRAME_ID_V2_EVENT_TIMING_CODES, "Event timing codes");
        idToValue.put(FRAME_ID_V2_FILE_TYPE, "Text: File type");
        idToValue.put(FRAME_ID_V2_GENERAL_ENCAPS_OBJECT, "General encapsulated datatype");
        idToValue.put(FRAME_ID_V2_GENRE, "Text: Content type");
        idToValue.put(FRAME_ID_V2_HW_SW_SETTINGS, "Text: Software/hardware and settings used for encoding");
        idToValue.put(FRAME_ID_V2_INITIAL_KEY, "Text: Initial key");
        idToValue.put(FRAME_ID_V2_IPLS, "Involved people list");
        idToValue.put(FRAME_ID_V2_ISRC, "Text: ISRC (International Standard Recording Code)");
        idToValue.put(FRAME_ID_V2_LANGUAGE, "Text: Language(s)");
        idToValue.put(FRAME_ID_V2_LENGTH, "Text: Length");
        idToValue.put(FRAME_ID_V2_LINKED_INFO, "Linked information");
        idToValue.put(FRAME_ID_V2_LYRICIST, "Text: Lyricist/text writer");
        idToValue.put(FRAME_ID_V2_MEDIA_TYPE, "Text: Media type");
        idToValue.put(FRAME_ID_V2_MPEG_LOCATION_LOOKUP_TABLE, "MPEG location lookup table");
        idToValue.put(FRAME_ID_V2_MUSIC_CD_ID, "Music CD Identifier");
        idToValue.put(FRAME_ID_V2_ORIGARTIST, "Text: Original artist(s)/performer(s)");
        idToValue.put(FRAME_ID_V2_ORIG_FILENAME, "Text: Original filename");
        idToValue.put(FRAME_ID_V2_ORIG_LYRICIST, "Text: Original Lyricist(s)/text writer(s)");
        idToValue.put(FRAME_ID_V2_ORIG_TITLE, "Text: Original album/Movie/Show title");
        idToValue.put(FRAME_ID_V2_PLAYLIST_DELAY, "Text: Playlist delay");
        idToValue.put(FRAME_ID_V2_PLAY_COUNTER, "Play counter");
        idToValue.put(FRAME_ID_V2_POPULARIMETER, "Popularimeter");
        idToValue.put(FRAME_ID_V2_PUBLISHER, "Text: Publisher");
        idToValue.put(FRAME_ID_V2_RECOMMENDED_BUFFER_SIZE, "Recommended buffer size");
        idToValue.put(FRAME_ID_V2_RELATIVE_VOLUME_ADJUSTMENT, "Relative volume adjustment");
        idToValue.put(FRAME_ID_V2_REMIXED, "Text: Interpreted, remixed, or otherwise modified by");
        idToValue.put(FRAME_ID_V2_REVERB, "Reverb");
        idToValue.put(FRAME_ID_V2_SET, "Text: Part of a set");
        idToValue.put(FRAME_ID_V2_SYNC_LYRIC, "Synchronized lyric/text");
        idToValue.put(FRAME_ID_V2_SYNC_TEMPO, "Synced tempo codes");
        idToValue.put(FRAME_ID_V2_TDAT, "Text: Date");
        idToValue.put(FRAME_ID_V2_TIME, "Text: Time");
        idToValue.put(FRAME_ID_V2_TITLE, "Text: Title/Songname/Content description");
        idToValue.put(FRAME_ID_V2_TITLE_REFINEMENT, "Text: Subtitle/Description refinement");
        idToValue.put(FRAME_ID_V2_TORY, "Text: Original release year");
        idToValue.put(FRAME_ID_V2_TRACK, "Text: Track number/Position in set");
        idToValue.put(FRAME_ID_V2_TRDA, "Text: Recording dates");
        idToValue.put(FRAME_ID_V2_TSIZ, "Text: Size");
        idToValue.put(FRAME_ID_V2_TYER, "Text: Year");
        idToValue.put(FRAME_ID_V2_UNIQUE_FILE_ID, "Unique file identifier");
        idToValue.put(FRAME_ID_V2_UNSYNC_LYRICS, "Unsychronized lyric/text transcription");
        idToValue.put(FRAME_ID_V2_URL_ARTIST_WEB, "URL: Official artist/performer webpage");
        idToValue.put(FRAME_ID_V2_URL_COMMERCIAL, "URL: Commercial information");
        idToValue.put(FRAME_ID_V2_URL_COPYRIGHT, "URL: Copyright/Legal information");
        idToValue.put(FRAME_ID_V2_URL_FILE_WEB, "URL: Official audio file webpage");
        idToValue.put(FRAME_ID_V2_URL_OFFICIAL_RADIO, "URL: Official radio station");
        idToValue.put(FRAME_ID_V2_URL_PAYMENT, "URL: Official payment site");
        idToValue.put(FRAME_ID_V2_URL_PUBLISHERS, "URL: Publishers official webpage");
        idToValue.put(FRAME_ID_V2_URL_SOURCE_WEB, "URL: Official audio source webpage");
        idToValue.put(FRAME_ID_V2_USER_DEFINED_INFO, "User defined text information frame");
        idToValue.put(FRAME_ID_V2_USER_DEFINED_URL, "User defined URL link frame");

        idToValue.put(FRAME_ID_V2_IS_COMPILATION,"Is Compilation");
        idToValue.put(FRAME_ID_V2_TITLE_SORT_ORDER_ITUNES,"Text: title sort order");
        idToValue.put(FRAME_ID_V2_ARTIST_SORT_ORDER_ITUNES,"Text: artist sort order");
        idToValue.put(FRAME_ID_V2_ALBUM_SORT_ORDER_ITUNES,"Text: album sort order");


        createMaps();

        multipleFrames.add(FRAME_ID_V2_ATTACHED_PICTURE);
        multipleFrames.add(FRAME_ID_V2_UNIQUE_FILE_ID);
        multipleFrames.add(FRAME_ID_V2_POPULARIMETER);

    }
}

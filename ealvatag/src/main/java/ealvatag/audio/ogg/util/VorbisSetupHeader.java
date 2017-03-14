package ealvatag.audio.ogg.util;

import ealvalog.Logger;
import ealvalog.Loggers;
import ealvatag.logging.Log;

import static ealvalog.LogLevel.DEBUG;

import java.nio.charset.StandardCharsets;

/**
 * Vorbis Setup header
 * <p>
 * We dont need to decode a vorbis setup header for metatagging, but we should be able to identify
 * it.
 *
 * @author Paul Taylor
 * @version 12th August 2007
 */
public class VorbisSetupHeader implements VorbisHeader {
  // Logger Object
  private static Logger LOG = Loggers.get(Log.MARKER);

  private boolean isValid = false;

  public VorbisSetupHeader(byte[] vorbisData) {
    decodeHeader(vorbisData);
  }

  public boolean isValid() {
    return isValid;
  }

  public void decodeHeader(byte[] b) {
    int packetType = b[FIELD_PACKET_TYPE_POS];
    LOG.log(DEBUG, "packetType" + packetType);
    String vorbis =
        new String(b, FIELD_CAPTURE_PATTERN_POS, FIELD_CAPTURE_PATTERN_LENGTH, StandardCharsets.ISO_8859_1);
    if (packetType == VorbisPacketType.SETUP_HEADER.getType() && vorbis.equals(CAPTURE_PATTERN)) {
      isValid = true;
    }
  }

}

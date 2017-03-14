/*
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
 *  Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA
 */
package ealvatag.tag.datatype;

import ealvatag.tag.InvalidDataTypeException;
import ealvatag.tag.id3.AbstractTagFrameBody;
import ealvatag.tag.id3.valuepair.EventTimingTypes;
import okio.Buffer;

import static ealvalog.LogLevel.TRACE;
import static ealvalog.LogLevel.WARN;

import java.io.EOFException;

/**
 * A single synchronized tempo code. Part of a list of temnpo codes
 * ({@link ealvatag.tag.datatype.SynchronisedTempoCodeList}), that are contained in
 * {@link ealvatag.tag.id3.framebody.FrameBodySYTC}
 *
 * @author <a href="mailto:hs@tagtraum.com">Hendrik Schreiber</a>
 * @version $Id:$
 */
public class SynchronisedTempoCode extends AbstractDataType implements Cloneable {

  private TempoCode tempo = new TempoCode(DataTypes.OBJ_SYNCHRONISED_TEMPO_DATA, null, 1);
  private NumberFixedLength timestamp = new NumberFixedLength(DataTypes.OBJ_DATETIME, null, 4);

  private SynchronisedTempoCode(final SynchronisedTempoCode copy) {
    super(copy);
    this.tempo.setValue(copy.tempo.getValue());
    this.timestamp.setValue(copy.timestamp.getValue());
  }

  SynchronisedTempoCode(final String identifier, final AbstractTagFrameBody frameBody) {
    this(identifier, frameBody, 0x00, 0L);
  }

  public SynchronisedTempoCode(final String identifier,
                               final AbstractTagFrameBody frameBody,
                               final int tempo,
                               final long timestamp) {
    super(identifier, frameBody);
    setBody(frameBody);
    this.tempo.setValue(tempo);
    this.timestamp.setValue(timestamp);
  }

  @Override
  public void setBody(final AbstractTagFrameBody frameBody) {
    super.setBody(frameBody);
    this.tempo.setBody(frameBody);
    this.timestamp.setBody(frameBody);
  }

  public long getTimestamp() {
    return ((Number)timestamp.getValue()).longValue();
  }

  public void setTimestamp(final long timestamp) {
    this.timestamp.setValue(timestamp);
  }

  public int getTempo() {
    return ((Number)tempo.getValue()).intValue();
  }

  public void setTempo(final int tempo) {
    if (tempo < 0 || tempo > 510) {
      throw new IllegalArgumentException("Tempo must be a positive value less than 511: " + tempo);
    }
    this.tempo.setValue(tempo);
  }

  @Override
  public int getSize() {
    return this.tempo.getSize() + this.timestamp.getSize();
  }

  @Override
  public void readByteArray(final byte[] buffer, final int originalOffset) throws InvalidDataTypeException {
    int localOffset = originalOffset;
    int size = getSize();

    LOG.log(TRACE, "offset:%s", localOffset);

    //The read has extended further than the defined frame size (ok to extend upto
    //size because the next datatype may be of length 0.)
    if (originalOffset > buffer.length - size) {
      LOG.log(WARN, "Invalid size for FrameBody");
      throw new InvalidDataTypeException("Invalid size for FrameBody");
    }

    tempo.readByteArray(buffer, localOffset);
    localOffset += tempo.getSize();
    timestamp.readByteArray(buffer, localOffset);
  }

  @Override public void read(final Buffer buffer, final int size) throws EOFException, InvalidDataTypeException {
    tempo.read(buffer, size);
    timestamp.read(buffer, size);
  }

  @Override
  public byte[] writeByteArray() {
    final byte[] typeData = this.tempo.writeByteArray();
    final byte[] timeData = this.timestamp.writeByteArray();
    if (typeData == null || timeData == null) { return null; }

    final byte[] objectData = new byte[typeData.length + timeData.length];
    System.arraycopy(typeData, 0, objectData, 0, typeData.length);
    System.arraycopy(timeData, 0, objectData, typeData.length, timeData.length);
    return objectData;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) { return true; }
    if (o == null || getClass() != o.getClass()) { return false; }
    if (!super.equals(o)) { return false; }

    final SynchronisedTempoCode that = (SynchronisedTempoCode)o;
    return !(this.getTempo() != that.getTempo() || this.getTimestamp() != that.getTimestamp());
  }

  @Override
  public int hashCode() {
    int result = tempo != null ? tempo.hashCode() : 0;
    result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "" + getTempo() + " (\"" + EventTimingTypes.getInstanceOf().getValue(getTempo()) + "\"), " +
        getTimestamp();
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return new SynchronisedTempoCode(this);
  }
}

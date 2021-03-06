/*
 * This program is free software; you can redistribute it and/or modify it under the 
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software 
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this 
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html 
 * or from the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright 2010-2013 Pentaho Corporation.  All rights reserved.
 */

package org.pentaho.reporting.platform.plugin;

import java.io.IOException;
import java.io.OutputStream;

public class TrackingOutputStream extends OutputStream
{
  private int trackingSize;
  private OutputStream wrappedStream;

  public TrackingOutputStream(final OutputStream wrapped)
  {
    this.wrappedStream = wrapped;
  }

  public void write(final int b) throws IOException
  {
    wrappedStream.write(b);
    trackingSize++;
  }

  public void write(final byte[] b) throws IOException
  {
    wrappedStream.write(b);
    trackingSize += b.length;
  }

  public void write(final byte[] b, final int off, final int len) throws IOException
  {
    wrappedStream.write(b, off, len);
    trackingSize += len;
  }

  public void flush() throws IOException
  {
    wrappedStream.flush();
  }

  public void close() throws IOException
  {
    wrappedStream.close();
  }

  public OutputStream getWrappedStream()
  {
    return wrappedStream;
  }

  public int getTrackingSize()
  {
    return trackingSize;
  }
}

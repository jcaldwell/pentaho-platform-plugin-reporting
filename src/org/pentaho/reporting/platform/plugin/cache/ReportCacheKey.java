package org.pentaho.reporting.platform.plugin.cache;

import java.util.Map;

import org.pentaho.reporting.engine.classic.core.cache.DataCacheKey;

/**
 * Todo: Document me!
 * <p/>
 * Date: 03.02.11
 * Time: 17:49
 *
 * @author Thomas Morgner.
 */
public class ReportCacheKey extends DataCacheKey
{
  private String sessionId;

  public ReportCacheKey(final String sessionId, final Map<String, Object> parameter)
  {
    this.sessionId = sessionId;
    for (final Map.Entry<String, Object> entry : parameter.entrySet())
    {
      addParameter(entry.getKey(), entry.getValue());
    }
  }

  public String getSessionId()
  {
    return sessionId;
  }

  public boolean equals(final Object o)
  {
    if (this == o)
    {
      return true;
    }
    if (o == null || getClass() != o.getClass())
    {
      return false;
    }
    if (!super.equals(o))
    {
      return false;
    }

    final ReportCacheKey that = (ReportCacheKey) o;

    if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null)
    {
      return false;
    }

    return true;
  }

  public int hashCode()
  {
    int result = super.hashCode();
    result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
    return result;
  }
}
package test.resource;

import java.io.IOException;

import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author WangPingChun
 */
public class MyResolver implements EntityResolver {
	@Override
	public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
		if (systemId.equals("http://www.myhost.com/today")) {

		}
		return null;
	}
}

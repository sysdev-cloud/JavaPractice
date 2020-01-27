JAXB Unmarshaller
1.1. Create Unmarshaller
JAXBContext jaxbContext     = JAXBContext.newInstance( Employee.class );
Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//Overloaded methods to unmarshal from different xml sources
Employee employee = (Employee) jaxbUnmarshaller.unmarshal( xmlSource );
1.2. Unmarshalling from an InputStream
InputStream inStream = new FileInputStream( "employee.xml" );
Employee employee = (Employee) jaxbUnmarshaller.unmarshal( inStream );
1.3. Unmarshalling from a URL
URL url = new URL( "http://localhost:8080/employee.xml" );
Employee employee = (Employee) jaxbUnmarshaller.unmarshal( url );
1.4. Unmarshalling the String content
String xmlString = "...";
Employee employee = (Employee) jaxbUnmarshaller.unmarshal(new StringReader(xmlString));
1.5. Unmarshalling from a org.w3c.dom.Node
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setNamespaceAware(true);
DocumentBuilder db = dbf.newDocumentBuilder();
Document document = db.parse(new File( "employee.xml")); //Node
Employee employee = (Employee) jaxbUnmarshaller.unmarshal( document );

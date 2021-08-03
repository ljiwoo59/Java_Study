package DOMParser;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EmployeeDomTest {

	public static void main(String[] args) throws Exception {
		File f = new File("src/DOMParser/employees.xml");
		
		// DOM Parser 생성
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = factory.newDocumentBuilder();
		
		Document doc = parser.parse(f); // DOM Tree 구성
		NodeList list = doc.getElementsByTagName("employee");
		ArrayList<Employee> elist = new ArrayList<>();
		
		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i); // employee 한 사람의 정보
			Element el = (Element)node;
			int id = Integer.parseInt(el.getAttribute("id"));
			int age = Integer.parseInt(el.getElementsByTagName("age").item(0).getTextContent());
			String name = el.getElementsByTagName("name").item(0).getTextContent();
			String gender = el.getElementsByTagName("gender").item(0).getTextContent();
			String role = el.getElementsByTagName("role").item(0).getTextContent();
			
			Employee one = new Employee(id, name, gender, age, role);
			elist.add(one);
		}
		
		for (Employee emp : elist) {
			System.out.println(emp);
		}
	}

}


public class MainTest {

	public static void main(String [] ddd) {
		
		LinkNode<Person> personLink0 = new LinkNode<Person>();
		
		Person xizhuang = new Person();
		
		xizhuang.age = 22;
		xizhuang.name ="ÍõÏ²×³";
		personLink0.data =xizhuang;
		
		LinkNode<Person> personLinkLast = new LinkNode<Person>();
		Person person = new Person();
		
		personLinkLast.data = person;
		personLinkLast.data.age = personLink0.data.age;
		personLinkLast.data.name = personLink0.data.name;
		
		personLink0.data.age = 30;
		LinkNode<Person> personLinkLast2 = personLinkLast;
		
		for(int i = 0; i < 100; i++) {
			LinkNode<Person> personLinknext = new LinkNode<Person>();
			Person personi = new Person();
			personi.age = 30 + i;
			personi.name ="ÕÅÍ®" + i;
			personLinknext.data = personi;
			personLinkLast2.nextNode = personLinknext;
			personLinkLast2 = personLinknext;
		}
		
		System.out.println(personLinkLast);
	}
}

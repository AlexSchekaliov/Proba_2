import fishAppSql.DBOperation;

public class Test01 {

	public static void main(String[] args) {

		DBOperation operation = new DBOperation();

		if (!operation.DeliteDB("my_test")) {
			System.out.println("��� �� ��������_1!!");
		}

		/*if (!operation.CreateDB("my_test")) {
			System.out.println("��� �� ��������_2!!");
		}*/

		System.out.println(operation.getListDBOnServer().toString());
	}
}

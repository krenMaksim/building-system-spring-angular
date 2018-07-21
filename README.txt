This project works with MySql.
For application start:
	1.To create a database run this script: building-system\db\buildingSystem.sql
	2.Copy in server.xml(use youself name and  password!):
		<Resource	auth="Container" 
				driverClassName="com.mysql.jdbc.Driver" 
				maxActive="100" 
				maxIdle="30" 
				maxWait="10000" 
				name="jdbc/building_system_resource" 
				password="root" 
				type="javax.sql.DataSource" 
				url="jdbc:mysql://localhost:3306/building_system" 
				username="root"
		/>
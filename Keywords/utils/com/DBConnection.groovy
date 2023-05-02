package utils.com

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.jcraft.jsch.JSch
import com.jcraft.jsch.Session
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement


public class DBConnection {
	@Keyword
	def String retrieveOneResult( String query) {

		Connection connection = null

		Properties config = new Properties()

		JSch jsch = new JSch()

		int remotePort = 3306

		String dbuserName = 'sunil.gokavi'

		String dbpassword = 'S^n!l0gOk@v!'

		String sshUser = 'sunil.gokavi'

		String sshHost = '10.16.0.3'

		String sshPassword = 'Sunilblume@2023'

		Session session = jsch.getSession(sshUser, sshHost)

		session.setPassword(sshPassword)

		//		String SshKeyFilepath = GlobalVariable.SshKeyFilepath

		//		jsch.addIdentity(SshKeyFilepath, sshPassword)

		config.put('StrictHostKeyChecking', 'no')

		config.put('ConnectionAttempts', '3')

		session.setConfig(config)

		session.connect()

		System.out.println('SSH Connected')

		int assinged_port = session.setPortForwardingL(0, 'data-blume-qadb-4.rez1.com', remotePort)

		String url = 'jdbc:mysql://localhost:'+assinged_port+'/'+'mbe'


		String value = ""
		try {
			connection=DriverManager.getConnection(url, dbuserName, dbpassword)
			Statement statement		=connection.createStatement()
			ResultSet rs = statement.executeQuery(query)
			if( rs!= null && rs.next() )
			{
				value	= rs.getString( 1 )
			}
			println('Cell value is: ' + value)
		}
		finally {
			if(connection != null && !connection.isClosed()){
				println('Closing Database Connection')
				connection.close();
			}
			if(session !=null && session.isConnected()){
				println('Closing SSH Connection')
				session.disconnect();
			}
		}

		return value
	}
}

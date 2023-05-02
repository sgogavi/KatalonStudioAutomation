import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

response = WS.sendRequest(findTestObject('MultipleShipments', [('shipNumber') : Shipment_Number, ('bolNumber') : BOL_Number
            , ('bkNumber') : Booking_Number, ('EquipNum') : Container_Number]))

WS.verifyElementPropertyValue(response, 'status', 'SUCCESS')

def shipsql = "select shipment_number from mbe.shipment where shipment_number ='" + Shipment_Number +"'"

String actualShipVal = CustomKeywords.'utils.com.DBConnection.retrieveOneResult'(shipsql)

if(!actualShipVal.equalsIgnoreCase(Shipment_Number) && actualShipVal != null ) {
	KeywordUtil.markFailed("shipment number is not matching with expected value")
}else {
	KeywordUtil.markPassed("shipment number is validated")
}

def bolsql = "select bill_of_lading_number from mbe.shipment where shipment_number ='" + Shipment_Number +"'"

String actualBolVal = CustomKeywords.'utils.com.DBConnection.retrieveOneResult'(bolsql)

if(!actualBolVal.equalsIgnoreCase(BOL_Number) && actualBolVal != null ) {
	KeywordUtil.markFailed("BOL number is not matching with expected value")
}else {
	KeywordUtil.markPassed("BOL number is validated")
}

def bksql = "select booking_number from mbe.shipment where shipment_number ='" + Shipment_Number +"'"

String actualBKVal = CustomKeywords.'utils.com.DBConnection.retrieveOneResult'(bksql)

if(!actualBKVal.equalsIgnoreCase(Booking_Number) && actualBKVal != null ) {
	KeywordUtil.markFailed("Booking number is not matching with expected value")
}else {
	KeywordUtil.markPassed("Booking number is validated")
}

def originatorNamesql = "select originator_name from mbe.shipment where shipment_number ='" + Shipment_Number +"'"

String actualoriginatorNameVal = CustomKeywords.'utils.com.DBConnection.retrieveOneResult'(originatorNamesql)


if(!actualoriginatorNameVal.equalsIgnoreCase('Nile Logistics Services Headquarters--Nile Logistics Services -LAX') && actualoriginatorNameVal != null ) {
	KeywordUtil.markFailed("Originator Name is not matching with expected value")
}else {
	KeywordUtil.markPassed("Originator Name is validated")
}


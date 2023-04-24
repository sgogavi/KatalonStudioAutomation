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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('https://test-apps.blumesolutions.com/blume-home/mbe-micro-ui#/shipment-center')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Recorded/Page_Login - CAS  Central Authentication Service/input_Username_username'), 
    'sunil.nileshipper@yopmail.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Recorded/Page_Login - CAS  Central Authentication Service/input_Password_password'), 
    'JmrMMdhGWS5NLJmovdnhvg==')

WebUI.click(findTestObject('Object Repository/Recorded/Page_Login - CAS  Central Authentication Service/input_Password_submit'))

WebUI.waitForPageLoad(300)

WebUI.waitForElementClickable(findTestObject('Object Repository/Recorded/Page_Blume Global/div_Select'), 60)

WebUI.click(findTestObject('Recorded/Page_Blume Global/div_Select'))

WebUI.click(findTestObject('Object Repository/Recorded/Page_Blume Global/li_Shipment'))

WebUI.setText(findTestObject('Object Repository/Recorded/Page_Blume Global/input_Shipment_k-textbox kendoSearchBox'), 'SHIP42478287SU10')

WebUI.click(findTestObject('Recorded/Page_Blume Global/svg_Shipment_mbe-seed-mbe-mui37 search-icon'))

WebUI.doubleClick(findTestObject('Object Repository/Recorded/Page_Blume Global/td_SHIP42478287SU10'))

WebUI.waitForPageLoad(200)

WebUI.scrollToElement(findTestObject('Page_Blume Global/div_DRAY (1)'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Blume Global/div_DRAY (1)'), 0)

WebUI.verifyElementPresent(findTestObject('Page_Blume Global/div_Domestic (1)'), 0)

WebUI.verifyElementPresent(findTestObject('Recorded/Page_Blume Global/div_Round Trip'), 0)

WebUI.closeBrowser()


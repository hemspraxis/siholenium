package com.praxis.siho.test.pages.main.psp;

import com.gargoylesoftware.htmlunit.PromptHandler;
import com.praxis.siho.test.pages.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.logging.FileHandler;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class CatalogoPlantillasPage extends Page<CatalogoPlantillasPage> {

    @FindBy(how = How.ID, using = "formTabla:j_idt85")
    private WebElement nuevoBtn;

    @FindBy(how = How.ID, using = "formTabla:j_idt86")
    private WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formPlatillas:j_idt44")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formPlatillas:j_idt46")
    private WebElement atrasBtn;

    @FindBy(how = How.ID, using = "formPlatillas:nombrePlantilla")
    private WebElement nombrePlantillaTxt;

    @FindBy(how = How.ID, using = "formPlatillas:descripcionPlantilla")
    private WebElement descripcionTxt;

    @FindBy(how = How.ID, using = "formPlatillas:cboTipo_label")
    private WebElement tipoPlantillaLstLabel;
    
    @FindBy(how = How.ID, using = "formPlatillas:cboTipo_panel")
    private WebElement tipoPlantillaLstPanel;

    @FindBy(how = How.ID, using = "formPlatillas:cboNivel_label")
    private WebElement nivelLstLabel;
    
    @FindBy(how = How.ID, using = "formPlatillas:cboNivel_panel")
    private WebElement nivelLstPanel;

    @FindBy(how = How.ID, using = "formPlatillas:cboFases_label")
    private WebElement fasesLstLabel;
    
    @FindBy(how = How.ID, using = "formPlatillas:cboFases_panel")
    private WebElement fasesLstPanel;

    @FindBy(how = How.ID, using = "formPlatillas:cboActividad_label")
    private WebElement actividadLstLabel;
    
    @FindBy(how = How.ID, using = "formPlatillas:cboActividad_panel")
    private WebElement actividadLstPanel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formPlatillas:j_idt81:j_idt82_input\"]")
    private WebElement seleccionarFile;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formPlatillas:j_idt81:j_idt82\"]/div[1]/button[1]")
    private WebElement uploadFile;

    @FindBy(how = How.ID, using = "formPlatillas:filefrm_content")
    private WebElement piper;
    
    @FindBy(how = How.ID, using = "messages")
    private WebElement responseMessages;
    
    public CatalogoPlantillasPage(WebDriver driver) {
        super(driver, PAGE_CAT_PLANTILLAS);
    }

    public void agregarPlantilla(){
    	try {
	        System.out.println("agregarPlantilla method");
	        safeClick(nuevoBtn);
	        System.out.println("zero");
	        safeSendKeys(nombrePlantillaTxt, "sel nom Plantilla");
	        System.out.println("one");
	        safeSendKeys(descripcionTxt, "descripcion plantilla");
	        System.out.println("twot");
	        selectValueOnPrimefacesListInLoop(tipoPlantillaLstLabel, tipoPlantillaLstPanel, "Praxis");
	        selectValueOnPrimefacesListInLoop(nivelLstLabel, nivelLstPanel, "PSPT 0.2");
	        System.out.println("three");
	        selectValueOnPrimefacesListInLoop(fasesLstLabel, fasesLstPanel, "1. PLANEACIÓN");
	        selectValueOnPrimefacesListInLoop(actividadLstLabel, actividadLstPanel, "2. ESTIMACIONES");
	
	        System.out.println("about to do crazy stuff");
	        System.out.println(piper.getTagName());
	        driver.findElement(By.xpath("//*[@id=\"formPlatillas:j_idt81:j_idt82_input\"]")).sendKeys("/home/praxis/Escritorio/PRUEBA_PLANTILLA.odt");
	        Thread.sleep(3000);
	        safeClick(uploadFile);
	        waitForWebElementDisplayed(responseMessages);
	        Thread.sleep(2000);
	        safeClick(guardarBtn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}

package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class EstimacionTamanioPage extends Page<EstimacionTamanioPage> {
    
	public static final String SUCCESS = "Registro almacenado correctamente.";
    
	@FindBy(how = How.ID, using = "formEstimacionTamano:j_idt53")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:MisProyectos_label")
    private WebElement proyectosLstLabel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:panelprincipalCronometro:MisProyectos_panel\"]/div/ul/li[2]")
    private WebElement proyectosOption;

    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:ciclo_label")
    private WebElement cicloPspLstLabel;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:ciclo_panel")
    private WebElement cicloPspLstPanel;
    
    private String cicloPspOptionXpath = "//*[@id=\"formEstimacionTamano:panelprincipalCronometro:ciclo_panel\"]/div/ul/li[8]";

    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:fase_label")
    private WebElement faseLstLabel;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:fase_panel")
    private WebElement faseLstPanel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:panelprincipalCronometro:fase_panel\"]/div/ul/li[2]")
    private WebElement faseOption;

    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:actividades_label")
    private WebElement actividadesLstLabel;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:actividades_panel")
    private WebElement actividadesLstPanel;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:panelprincipalCronometro:actividades_panel\"]/div/ul/li[2]")
    private WebElement actividadesOption;

    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:j_idt75")
    private WebElement pauseCronometroBtn;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:panelprincipalCronometro:j_idt89")
    private WebElement playCronometroBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:cboTipMedida_label")
    private WebElement tipoMedidaLstLabel;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:cboTipMedida_panel")
    private WebElement tipoMedidaLstPanel;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:j_idt98")
    private WebElement partesBaseNuevoBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:j_idt170")
    private WebElement partesBaseEliminarBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt164\"]/span[1]")
    private WebElement partesBaseEditar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt164\"]/span[2]")
    private WebElement partesBaseGuardar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt164\"]/span[3]")
    private WebElement partesBaseCancelar;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt121")
    private WebElement partesBaseNombreTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt126")
    private WebElement partesBaseEstBaseTxt;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt131")
    private WebElement partesBaseEstRemovidosTxt;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt136")
    private WebElement partesBaseEstModificadosTxt;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt141")
    private WebElement partesBaseEstAgregadasTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt146")
    private WebElement partesBaseRealesBaseTxt;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt151")
    private WebElement partesBaseRealesRemovidosTxt;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt156")
    private WebElement partesBaseRealesModificadosTxt;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesBase:0:j_idt161")
    private WebElement partesBaseRealesAgregadasTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:j_idt181")
    private WebElement partesAdicionalesNuevoBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:j_idt182")
    private WebElement partesAdicionalesEliminarBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt247\"]/span[1]")
    private WebElement partesAdicionalesEditar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt247\"]/span[2]")
    private WebElement partesAdicionalesGuardar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt247\"]/span[3]")
    private WebElement partesAdicionalesCancelar;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt204")
    private WebElement partesAdicionalesNombreTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt214")
    private WebElement partesAdicionalesEstObjetosTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt222")
    private WebElement partesAdicionalesEstTamanoTxt;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt233")
    private WebElement partesAdicionalesRealesTamanoTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:j_idt238")
    private WebElement partesAdicionalesRealesObjetosTxt;
   
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:j_idt260")
    private WebElement partesReutilizablesNuevoBtn;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:j_idt261")
    private WebElement partesReutilizablesEliminarBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesReutilizables:0:j_idt290\"]/span[1]")
    private WebElement partesReutilizablesEditar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesReutilizables:0:j_idt290\"]/span[2]")
    private WebElement partesReutilizablesGuardar;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems:tablePartesReutilizables:0:j_idt290\"]/span[3]")
    private WebElement partesReutilizablesCancelar;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesReutilizables:0:j_idt277")
    private WebElement partesReutilizablesNombreTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesReutilizables:0:j_idt282")
    private WebElement partesReutilizablesEstTamanoTxt;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesReutilizables:0:j_idt287")
    private WebElement partesReutilizablesRealesTamanoTxt;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems\"]/h3[2]")
    private WebElement partesAdicionalesAccordion;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"formEstimacionTamano:acordionPartesItems\"]/h3[3]")
    private WebElement partesReutilizablesAccordion;

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:cboEstimadoTipo_label")
    private WebElement partesAdicionalesEstTipoLstLabel;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:cboEstimadoTipo_panel")
    private WebElement partesAdicionalesEstTipoLstPanel;
    private final String PROCESS = "PROCESS";

    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:cboEstimadoTamReal_label")
    private WebElement partesAdicionalesEstTamanoRelativoLstLabel;
    
    @FindBy(how = How.ID, using = "formEstimacionTamano:acordionPartesItems:tablePartesAdicionales:0:cboEstimadoTamReal_panel")
    private WebElement partesAdicionalesEstTamanoRelativoLstPanel;
    private final String GRANDE = "GRANDE";

    @FindBy(how = How.ID, using = "formEstimacionTamano:messages")
    private WebElement responseMessageDiv;

    public EstimacionTamanioPage(WebDriver driver) {
        super(driver, PAGE_ESTIMACION_TAMANIO);
    }

    public String estimarTamanio(String cicloPsp){
        String responseMessage = null;
        try {
        	safeSelectOptionOnPrimefacesList(proyectosLstLabel, proyectosOption);
        	Thread.sleep(1000);
	        waitForWebElementClickable(cicloPspLstLabel);
	        Thread.sleep(1000);
	        selectValueOnPrimefacesList(cicloPspLstLabel, cicloPspLstPanel, cicloPsp, 2500);
	        scrollUpOrDown(-500);
	        Thread.sleep(2000);
	        selectValueOnPrimefacesList(faseLstLabel, faseLstPanel, "4. COMPILACIÓN", 2500);
	        Thread.sleep(2000);
	        selectValueOnPrimefacesList(actividadesLstLabel, actividadesLstPanel, "1. COMPILAR EL PROGRAMA HASTA QUE NO HAYA ERRORES", 2000);
	        Thread.sleep(2000);
	        selectValueOnPrimefacesList(tipoMedidaLstLabel, tipoMedidaLstPanel, "PUNTOS DE COMPLEJIDAD JAVA", 1500);
	        Thread.sleep(1000);
	        safeClick(playCronometroBtn);
	        Thread.sleep(1000);
	        scrollUpOrDown(250);
	        llenarPartesBase(cicloPsp);
	        llenarPartesAdicionales(cicloPsp);
	        llenarPartesReutilizables(cicloPsp);
	        Thread.sleep(1000);
	        scrollUpOrDown(-250);
	        Thread.sleep(1000);
	        safeClick(guardarBtn);
	        responseMessage = getErrorMessagesFrom(responseMessageDiv).get(0);
	        System.out.println("about to send: " + responseMessage);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseMessage;
    }
    
    public void llenarPartesBase(String cicloPsp){
        try {
            Thread.sleep(2000);
            safeClick(partesBaseNuevoBtn);
	        Thread.sleep(1000);
            safeClick(partesBaseEditar);
            safeSendKeys(partesBaseNombreTxt, cicloPsp + "B");
            safeSendKeys(partesBaseEstBaseTxt, "3");
            safeSendKeys(partesBaseEstRemovidosTxt, "3");
            safeSendKeys(partesBaseEstModificadosTxt, "3");
            safeSendKeys(partesBaseEstAgregadasTxt, "3");
            safeSendKeys(partesBaseRealesBaseTxt, "3");
            safeSendKeys(partesBaseRealesRemovidosTxt, "3");
            safeSendKeys(partesBaseRealesModificadosTxt, "3");
            safeSendKeys(partesBaseRealesAgregadasTxt, "3");
            safeClick(partesBaseGuardar);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void llenarPartesAdicionales(String cicloPsp){
        safeClick(partesAdicionalesAccordion);
        try{
            Thread.sleep(2000);
            safeClick(partesAdicionalesNuevoBtn);
	        Thread.sleep(1000);
            safeClick(partesAdicionalesEditar);
            safeSendKeys(partesAdicionalesNombreTxt, cicloPsp + "A");
            selectValueOnPrimefacesList(partesAdicionalesEstTipoLstLabel, partesAdicionalesEstTipoLstPanel, PROCESS);
            safeSendKeys(partesAdicionalesEstObjetosTxt, "4");
            selectValueOnPrimefacesList(partesAdicionalesEstTamanoRelativoLstLabel, partesAdicionalesEstTamanoRelativoLstPanel, GRANDE, 3000);
            safeSendKeys(partesAdicionalesRealesTamanoTxt, "3");
            safeSendKeys(partesAdicionalesRealesObjetosTxt, "3");
            safeClick(partesAdicionalesGuardar);
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }
    
    public void llenarPartesReutilizables(String cicloPsp){
        safeClick(partesReutilizablesAccordion);
        try{
            Thread.sleep(2000);
            safeClick(partesReutilizablesNuevoBtn);
	        Thread.sleep(1000);
            safeClick(partesReutilizablesEditar);
            safeSendKeys(partesReutilizablesNombreTxt, cicloPsp + "R");
            safeSendKeys(partesReutilizablesEstTamanoTxt, "4");
            safeSendKeys(partesReutilizablesRealesTamanoTxt, "3");
            safeClick(partesReutilizablesGuardar);
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }

}

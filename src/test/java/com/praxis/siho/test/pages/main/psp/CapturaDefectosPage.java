package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class CapturaDefectosPage extends Page<CapturaDefectosPage> {

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:selecTipoDefecto_label")
    private WebElement tipoDefectoLstLabel;
    
    @FindBy(how = How.ID, using = "j_idt29:j_idt39:selecTipoDefecto_panel")
    private WebElement tipoDefectoLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:calendarFecha_input")
    private WebElement datePickerStarter;

    @FindBy(how = How.ID, using = "ui-datepicker-div")
    private WebElement uiDatePickerDiv;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:descripcion")
    private WebElement descProblemaTxt;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:causaRaiz")
    private WebElement causaRaizTxt;

    @FindBy(how = How.ID, using = "j_idt29:j_idt59")
    private WebElement capturaBtn;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:cuentSoluciones")
    private WebElement cuantosDefectosIgualesTxt;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:selectInyectado_label")
    private WebElement inyeccionLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:selectInyectado_panel")
    private WebElement inyeccionLstPanel;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:selectCompilacion_label")
    private WebElement remocionLstLabel;

    @FindBy(how = How.ID, using = "j_idt29:j_idt39:selectCompilacion_panel")
    private WebElement remocionLstPanel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:MisProyectos_label")
    private WebElement proyectosLstLabel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:MisProyectos_panel")
    private WebElement proyectosLstPanel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:ciclo_label")
    private WebElement cicloLstLabel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:ciclo_panel")
    private WebElement cicloLstPanel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:fase_label")
    private WebElement faseLstLabel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:fase_panel")
    private WebElement faseLstPanel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:actividades_label")
    private WebElement actividadesLstLabel;

    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:actividades_panel")
    private WebElement actividadesLstPanel;

    @FindBy(how = How.ID, using = "j_idt41:j_idt48")
    private WebElement guardarBtn;

    @FindBy(how = How.LINK_TEXT, using = "Bitácora Defectos ")
    private WebElement bitacoraDefectosBtn;
    
    @FindBy(how = How.ID, using = "j_idt41:panelprincipalCronometro:j_idt122")
    private WebElement playCronometro;
    
    @FindBy(how = How.ID, using = "j_idt41:j_idt44")
    private WebElement nuevoBtn;

    public CapturaDefectosPage(WebDriver driver) {
        super(driver, PAGE_CAPTURA_DEFECTOS);
    }
    public void capturarDefecto(String cicloPsp){
        selectValueOnPrimefacesListInLoop(proyectosLstLabel, proyectosLstPanel, 1);
        selectValueOnPrimefacesListInLoop(cicloLstLabel, cicloLstPanel, cicloPsp);
        scrollUpOrDown(-500);
        selectValueOnPrimefacesListInLoop(faseLstLabel, faseLstPanel, 3);
        selectValueOnPrimefacesListInLoop(actividadesLstLabel, actividadesLstPanel, 1);
        safeClick(playCronometro);
        safeClick(nuevoBtn);
        selectValueOnPrimefacesList(tipoDefectoLstLabel, tipoDefectoLstPanel, "SISTEMA");
        setDateOnPicker(datePickerStarter, uiDatePickerDiv, "10", "9", "2015");
        selectValueOnPrimefacesListInLoop(inyeccionLstLabel, inyeccionLstPanel, "3. CODIFICACIÓN");
        selectValueOnPrimefacesListInLoop(remocionLstLabel, remocionLstPanel, "4. COMPILACIÓN");
        safeSendKeys(descProblemaTxt, "error de compilador");
        safeSendKeys(causaRaizTxt, "exploto la maquina");
        safeSendKeys(cuantosDefectosIgualesTxt, "7");
        scrollUpOrDown(-150);
        safeClick(guardarBtn);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

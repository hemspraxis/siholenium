package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

import static com.praxis.siho.test.common.constants.PageURLsConstants.*;
/**
 * Created by administrativo on 30/07/15.
 */
public class ConfiguracionProyectosPage extends Page<ConfiguracionProyectosPage> {
    public static final String SUCCESS = "Registro almacenado correctamente.";
    public static final String NOMBRE_CICLO_PSP_REPETIDO = "Nombre del ciclo existente para el proyecto seleccionado, Ingresa uno diferente.";

    @FindBy(how = How.ID, using = "formTablaProyecto:j_idt76")
    private WebElement nuevoBtn;

    @FindBy(how = How.ID, using = "formTablaProyecto:j_idt77")
    private WebElement eliminarBtn;

    @FindBy(how = How.ID, using = "formProyecto:j_idt44")
    private WebElement guardarBtn;

    @FindBy(how = How.ID, using = "formProyecto:j_idt46")
    private WebElement cancelarBtn;

    @FindBy(how = How.ID, using = "formProyecto:cveproyecto_label")
    private WebElement cveProyectoLstLabel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formProyecto:cveproyecto_panel\"]/div/ul/li[2]")
    private WebElement cveProyectoOption;

    @FindBy(how = How.ID, using = "formProyecto:input_proyectos")
    private WebElement nomCicloPspTxt;


    @FindBy(how = How.ID, using = "formProyecto:selectNivelPSP_label")
    private WebElement nivelPspLstLabel;

    @FindBy(how = How.XPATH, using = "//*[@id=\"formProyecto:selectNivelPSP_panel\"]/div/ul/li[4]")
    private WebElement nivelPspOption;

    @FindBy(how = How.ID, using = "messages")
    private WebElement messageResponse;

    public ConfiguracionProyectosPage(WebDriver driver) {
        super(driver, PAGE_CONFIG_PROYECTOS);
    }

    public void agregarNuevaConfiguracionProyecto(String nomCicloPsp){
        safeClick(nuevoBtn);
        safeSelectOptionOnPrimefacesList(cveProyectoLstLabel, cveProyectoOption);
        safeSendKeys(nomCicloPspTxt, nomCicloPsp);
        safeSelectOptionOnPrimefacesList(nivelPspLstLabel, nivelPspOption);
        safeClick(guardarBtn);
        System.out.println("almost done");
        waitForWebElementDisplayed(messageResponse);
    }


}

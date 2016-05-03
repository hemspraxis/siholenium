package com.praxis.siho.test.pages.main.asignacion;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.praxis.siho.test.pages.Page;

import static com.praxis.siho.test.common.util.RandomData.generateRandomNonZeroNumberUpTo;
import static com.praxis.siho.test.common.constants.PageURLsConstants.PAGE_PROX_DESASIGNARSE;

public class ProximoDesasignarsePage extends Page<ProximoDesasignarsePage> {

	@FindBy(how = How.XPATH, using = "//*[@id=\"formProximosAdesasignarse:acoordeon:radioTipoConsulta\"]/tbody/tr/td[1]/div/div[2]/span")
	//@FindBy(how = How.XPATH, using = "//*[@id=\"formProximosAdesasignarse:radioTipoConsulta\"]/tbody/tr/td[1]/div/div[2]/span")
	private WebElement tipoConsultaRecurso;	//radio button

	@FindBy(how = How.XPATH, using = "//*[@id=\"formProximosAdesasignarse:acoordeon:radioTipoConsulta\"]/tbody/tr/td[3]/div/div[2]/span")
	//@FindBy(how = How.XPATH, using = "//*[@id=\"formProximosAdesasignarse:radioTipoConsulta\"]/tbody/tr/td[3]/div/div[2]/span")
	private WebElement tipoConsultaDias; //radio button
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:acoordeon:j_idt58")
	private WebElement consultaRecursoLabel; //label for list

	@FindBy(how = How.ID, using = "formProximosAdesasignarse:acoordeon:lblInputDias")
	//@FindBy(how = How.ID, using = "formProximosAdesasignarse:lblInputDias")
	private WebElement diasProxDesasigLabel; //input text
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:acoordeon:cboRecursos_label")
	//@FindBy(how = How.ID, using = "formProximosAdesasignarse:cboRecursos_label")
	private WebElement recursosList;

	// resource from list panel
	private String randomRecursoXpath = "//*[@id=\"formProximosAdesasignarse:acoordeon:cboRecursos_panel\"]/div/ul/li["
			+ generateRandomNonZeroNumberUpTo(798) + "]";
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:acoordeon:inputDias")
	private WebElement diasInputTxt;
	
	@FindBy(how = How.ID, using = "formProximosAdesasignarse:acoordeon:j_idt66")
	private WebElement consultarBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"formProximosAdesasignarse:acoordeon\"]/h3/span")
	private WebElement acoordeon;
	
	public ProximoDesasignarsePage(WebDriver driver) {
		super(driver, PAGE_PROX_DESASIGNARSE);
	}

	public boolean seleccionarRecursoAleatoriamente(){
		boolean success = false;		
		try {
			waitForWebElementDisplayed(acoordeon);
			safeClick(acoordeon);
			Thread.sleep(1000);
			waitForWebElementDisplayed(tipoConsultaRecurso);
			safeClick(tipoConsultaRecurso);			
			if(isLabelWithTextPresent(consultaRecursoLabel, "Recurso:")){			
				safeSelectOptionOnPrimefacesList(recursosList, driver.findElement(By.xpath(randomRecursoXpath)));
				success = true;
			}
			return success;
		} catch (TimeoutException e) {
			System.out.println("seleccionarRecursoAleatoriamente " + e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean mostrarDesasignacionAcordeADias(){
		boolean success = false;
		try {
			waitForWebElementDisplayed(acoordeon);
			safeClick(acoordeon);
			Thread.sleep(1000);
			waitForWebElementDisplayed(tipoConsultaDias);
			safeClick(tipoConsultaDias);
			if(isLabelWithTextPresent(diasProxDesasigLabel, "Días próximos a desasignarse:*")){
				safeSendKeys(diasInputTxt, String.valueOf(generateRandomNonZeroNumberUpTo(10)));
				safeClick(consultarBtn);
				success = true;
			}
		} catch (TimeoutException e) {
			System.out.println("mostrarDesasignacionAcordeADias " + e);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return success;
	}
}

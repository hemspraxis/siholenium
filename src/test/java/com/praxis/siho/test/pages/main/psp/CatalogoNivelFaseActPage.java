package com.praxis.siho.test.pages.main.psp;

import com.praxis.siho.test.pages.Page;
import org.openqa.selenium.By;
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
public class CatalogoNivelFaseActPage extends Page<CatalogoNivelFaseActPage>{
    public final String SUCCESS = "Se ha eliminado correctamente.";
    @FindBy(how = How.XPATH, using = "//*[@id=\"idAcordeon\"]/h3[1]")
    private WebElement nivelAccordion;
    @FindBy(how = How.XPATH, using = "//*[@id=\"idAcordeon\"]/h3[2]")
    private WebElement faseAccordion;
    @FindBy(how = How.XPATH, using = "//*[@id=\"idAcordeon\"]/h3[3]")
    private WebElement actividadAccordion;

    @FindBy(how = How.ID, using = "idAcordeon:formCapNivel:j_idt48")
    private WebElement nivelNuevoBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapNivel:j_idt49")
    private WebElement nivelEliminarBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapNivel:j_idt45")
    private WebElement nivelGuardarBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapNivel:j_idt47")
    private WebElement nivelAtrasBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapNivel:capNivel")
    private WebElement nivelTxt;

    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:j_idt65")
    private WebElement faseNuevoBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:j_idt66")
    private WebElement faseEliminarBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:j_idt62")
    private WebElement faseGuardarBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:j_idt64")
    private WebElement faseAtrasBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:capFase")
    private WebElement faseTxt;
    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:cboNivel_label")
    private WebElement faseNivelLstLabel;
    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:cboNivel_panel")
    private WebElement faseNivelLstPanel;

    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:j_idt89")
    private WebElement actividadNuevoBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:j_idt90")
    private WebElement actividadEliminarBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:j_idt86")
    private WebElement actividadGuardarBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:j_idt88")
    private WebElement actividadAtrasBtn;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:capActividad")
    private WebElement actividadTxt;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:cboNivel2_label")
    private WebElement actividadNivelLstLabel;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:cboNivel2_panel")
    private WebElement actividadNivelLstPanel;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:cboFase2_label")
    private WebElement actividadFaseLstLabel;
    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:cboFase2_panel")
    private WebElement actividadFaseLstPanel;

    // borrar registry
    @FindBy(how = How.ID, using = "idAcordeon:formCapNivel:tablaNivel_data")
    private WebElement nivelTableBody;

    @FindBy(how = How.ID, using = "idAcordeon:formCapFase:tablaFase_data")
    private WebElement faseTableBody;

    @FindBy(how = How.ID, using = "idAcordeon:formCapActividad:tablaActividad_data")
    private WebElement actividadTableBody;

    @FindBy(how = How.XPATH, using = "//*[@id=\"idAcordeon:formCapNivel:tablaNivel_paginator_top\"]/span[5]/span")
    private WebElement endOfPagesNivel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"idAcordeon:formCapFase:tablaFase_paginator_top\"]/span[5]/span")
    private WebElement endOfPagesFase;
    @FindBy(how = How.XPATH, using = "//*[@id=\"idAcordeon:formCapActividad:tablaActividad_paginator_top\"]/span[5]")
    private WebElement endOfPagesActividad;

    @FindBy(how = How.ID, using = "messages")
    private WebElement responseMessages;

    public CatalogoNivelFaseActPage(WebDriver driver) {
        super(driver, PAGE_CAT_NIVEL_FASE_ACT);
    }

    public boolean borrarRegistroDeCatalogoNivelFaseActividades(String descNivel, String descFase, String descActividad){
        List<String> msgs;
        try {
            msgs = borrarRegistroActividad(actividadTableBody, endOfPagesActividad, actividadEliminarBtn, descNivel, descFase, descActividad);
            Thread.sleep(3000);
            if (!msgs.isEmpty() && !msgs.get(0).equals(SUCCESS)){
                return false;
            }
            Thread.sleep(1000);
            msgs = borrarRegistroFase(faseTableBody, endOfPagesFase, faseEliminarBtn, descNivel, descFase);
            Thread.sleep(3000);
            if (!msgs.isEmpty() && !msgs.get(0).equals(SUCCESS)){
                return false;
            }
            Thread.sleep(1000);
            msgs = borrarRegistroNivel(nivelTableBody, endOfPagesNivel, nivelEliminarBtn, descNivel);
            Thread.sleep(3000);
            if (!msgs.isEmpty() && !msgs.get(0).equals(SUCCESS)){
                return false;
            }
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<String> borrarRegistroNivel(WebElement tableBody, WebElement paginator, WebElement eliminarBtn, String descNivel) throws InterruptedException {
        Thread.sleep(3000);
        safeClick(nivelAccordion);
        return borrarRegistro(tableBody, paginator, eliminarBtn, descNivel, null, null);
    }
    public List<String> borrarRegistroFase(WebElement tableBody, WebElement paginator, WebElement eliminarBtn, String descNivel, String descFase) throws InterruptedException {
        Thread.sleep(2000);
        safeClick(faseAccordion);
        return borrarRegistro(tableBody, paginator, eliminarBtn, descNivel, descFase, null);
    }

    private List<String> borrarRegistroActividad(WebElement tableBody, WebElement paginator, WebElement eliminarBtn, String descNivel, String descFase, String descActividad){
        safeClick(actividadAccordion);
        return borrarRegistro(tableBody, paginator, eliminarBtn, descNivel, descFase, descActividad);
    }
    private List<String> borrarRegistro(WebElement tableBody, WebElement paginator, WebElement eliminarBtn, String descNivel, String descFase, String descActividad){
        List<String> errorsLst = new ArrayList<String>();
        try {
            Thread.sleep(3000);
            safeClick(paginator);
            Thread.sleep(3000);
	        for (WebElement row : tableBody.findElements(By.tagName("tr"))) {
	        	Thread.sleep(1000);
	            List<WebElement> cols = row.findElements(By.tagName("td"));
	            Thread.sleep(1000);
	            if (descNivel != null && descFase != null && descActividad != null) {
	            	Thread.sleep(1000);
	                if (cols.get(1).getText().equals(descNivel) && cols.get(2).getText().equals(descFase) && cols.get(3).getText().equals(descActividad)) {
	                	Thread.sleep(1000);
	                	safeClick(cols.get(0).findElement(By.tagName("span")));
	                	Thread.sleep(1000);
	                    safeClick(eliminarBtn);
	                    Thread.sleep(3000);
	                    waitForWebElementDisplayed(responseMessages);
	                    errorsLst = getErrorMessagesFrom(responseMessages);
	                    break;
	                }
	            } else if (descNivel != null && descFase != null && descActividad == null) {
	                if (cols.get(1).getText().equals(descNivel) && cols.get(2).getText().equals(descFase)) {
	                	Thread.sleep(1000);
	                	safeClick(cols.get(0).findElement(By.tagName("span")));
	                	Thread.sleep(1000);
	                    safeClick(eliminarBtn);
	                    Thread.sleep(3000);
	                    waitForWebElementDisplayed(responseMessages);
	                    errorsLst = getErrorMessagesFrom(responseMessages);
	                    break;
	                }
	            } else if (descNivel != null && descFase == null && descActividad == null) {
	                if (cols.get(1).getText().equals(descNivel)) {
	                	Thread.sleep(1000);
	                	safeClick(cols.get(0).findElement(By.tagName("span")));
	                	Thread.sleep(1000);
	                    safeClick(eliminarBtn);
	                    Thread.sleep(3000);
	                    waitForWebElementDisplayed(responseMessages);
	                    errorsLst = getErrorMessagesFrom(responseMessages);
	                    break;
	                }
	            }
	        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return errorsLst;
    }

    public List<String> agregarACatalogoNivelFaseActividades(String descNivel, String descFase, String descActividad){
        List<String>responseMessages = new ArrayList<String>();
        agregarNivel(descNivel);
        agregarFase(descFase, descNivel);
        agregarActividad(descActividad, descNivel, descFase);
        return responseMessages;
    }

    private void agregarNivel(String nivelDesc){
        safeClick(nivelNuevoBtn);
        agregarNuevoRegistroACatalogo(nivelGuardarBtn, nivelTxt, nivelDesc);
    }

    private void agregarFase(String faseDesc, String nivelOption){
        safeClick(faseAccordion);
        safeClick(faseNuevoBtn);
        agregarNuevoRegistroACatalogo(faseGuardarBtn, faseTxt, faseDesc, faseNivelLstLabel, faseNivelLstPanel, nivelOption);
    }

    private void agregarActividad(String actividadDesc, String nivelOption, String faseOption){
        safeClick(actividadAccordion);
        safeClick(actividadNuevoBtn);
        agregarNuevoRegistroACatalogo(actividadGuardarBtn, actividadTxt, actividadDesc, actividadNivelLstLabel, actividadNivelLstPanel, nivelOption, actividadFaseLstLabel, actividadFaseLstPanel, faseOption);
    }

    private void agregarNuevoRegistroACatalogo(WebElement guardarBtn, WebElement inputTxt, String descTxt){
        agregarNuevoRegistroACatalogo(guardarBtn, inputTxt, descTxt, null, null, null);
    }

    private void agregarNuevoRegistroACatalogo(WebElement guardarBtn, WebElement inputTxt, String descTxt, WebElement lstLblStarter, WebElement lstPanel, String optionTxt){
        agregarNuevoRegistroACatalogo(guardarBtn, inputTxt, descTxt, lstLblStarter, lstPanel, optionTxt, null, null, null);
    }

    private void agregarNuevoRegistroACatalogo(WebElement guardarBtn, WebElement inputTxt, String descTxt, WebElement lstLblStarter, WebElement lstPanel, String optionTxt, WebElement lstLblStarter2, WebElement lstPanel2, String optionTxt2){
        if (lstLblStarter == null){
            safeSendKeys(inputTxt, descTxt);
        } else if (lstLblStarter != null && lstLblStarter2 == null){
            selectValueOnPrimefacesList(lstLblStarter, lstPanel, optionTxt);
            safeSendKeys(inputTxt, descTxt);
        } else if (lstLblStarter != null && lstLblStarter2 != null){
            selectValueOnPrimefacesList(lstLblStarter,lstPanel, optionTxt);
            selectValueOnPrimefacesList(lstLblStarter2,lstPanel2, optionTxt2);
            safeSendKeys(inputTxt, descTxt);
        }
        safeClick(guardarBtn);
    }
}

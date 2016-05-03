package com.praxis.siho.test.smoke;
import static com.praxis.siho.test.common.constants.GroupsConstants.ACTIVIDADES;
import static com.praxis.siho.test.common.constants.GroupsConstants.ASIGNACIONES;
import static com.praxis.siho.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.siho.test.common.constants.GroupsConstants.SMOKE;

import com.praxis.siho.test.common.util.RandomData;
import org.eclipse.jetty.websocket.RandomMaskGen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.actividades.CatalogoActividadesPage;
import com.praxis.siho.test.pages.main.asignacion.AsignacionLineaTecnologicaPage;

import static com.praxis.siho.test.common.util.RandomData.*;

public class ModuloActividadesSmokeTest extends WebDriverSetup {

	final String randomCve   = getRandomLetter(false) + getRandomLetter(true) + (int)(Math.random() * 100);
	final String randomCve2   = getRandomLetter(false) + getRandomLetter(true) + (int)(Math.random() * 100);
	final String descripcion = getRandomLetter(false) + getRandomLetter(true) + randomCve;
	final String descripcion2 = getRandomLetter(false) + getRandomLetter(true) + randomCve2;
	
	@Test(enabled = true, priority = 1, groups = {SMOKE, ACTIVIDADES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
        testCase("signOn");
        LogInPage logInPage = new LogInPage(driver).refreshPage();
        Assert.assertNotNull(logInPage);
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);
        System.out.println("----------------SIGN ON COMPLETE---------------------");       
    }
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, ACTIVIDADES})
	public void casoAgregarActividad() throws InterruptedException{
        testCase("casoAgregarActividad");
		MainPage mainPage = new MainPage(driver).refreshPage();
        CatalogoActividadesPage  catalogoActividadesPage = mainPage.linkToCatalogoActividades();
        Assert.assertNotNull(catalogoActividadesPage, "failed to load Catálogo de actividades");
        catalogoActividadesPage.agregarActividadSinClave(randomCve, descripcion);
        System.out.println("----------------CASO AGREGAR ACTIVIDAD COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 3, groups = {SMOKE, ACTIVIDADES})
	public void casoEditarActividad() {
		testCase("casoEditarActividad");
		MainPage mainPage = new MainPage(driver).refreshPage();
		CatalogoActividadesPage  catalogoActividadesPage = mainPage.linkToCatalogoActividades();
		Assert.assertNotNull(catalogoActividadesPage, "failed to load Catálogo de actividades");
		catalogoActividadesPage.editarActividadSinClave(descripcion, descripcion + "A");
       	System.out.println("----------------CASO EDITAR ACTIVIDAD COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 4, groups = {SMOKE, ACTIVIDADES})
	public void casoBorrarLActividad() {
		testCase("casoBorrarActividad");
		MainPage mainPage = new MainPage(driver).refreshPage();
		CatalogoActividadesPage  catalogoActividadesPage = mainPage.linkToCatalogoActividades();
        Assert.assertNotNull(catalogoActividadesPage, "failed to load Catálogo de actividades");        
       	System.out.println(" about to do logical deletion");
        catalogoActividadesPage.agregarActividadSinClave(randomCve2, descripcion2);     
       	catalogoActividadesPage.refreshPage();
       	catalogoActividadesPage.borrarActividadSinClave(descripcion2);
       	System.out.println("----------------CASO BORRAR ACTIVIDAD COMPLETE---------------------");
	}
}

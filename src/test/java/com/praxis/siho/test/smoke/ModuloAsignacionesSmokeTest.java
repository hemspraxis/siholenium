package com.praxis.siho.test.smoke;

import com.praxis.siho.test.pages.main.proyectos.CatalogoProyectosPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.asignacion.AsignacionLineaTecnologicaPage;
import com.praxis.siho.test.pages.main.asignacion.ConsultaAsignacionesPage;
import com.praxis.siho.test.pages.main.asignacion.EstatusAsignacionPage;
import com.praxis.siho.test.pages.main.asignacion.ProximoDesasignarsePage;
import com.praxis.siho.test.pages.main.asignacion.TipoAsignacionPage;
import java.util.List;
import static com.praxis.siho.test.common.constants.GroupsConstants.ASIGNACIONES;
import static com.praxis.siho.test.common.constants.GroupsConstants.SIGNON;
import static com.praxis.siho.test.common.constants.GroupsConstants.SMOKE;
import static com.praxis.siho.test.common.util.RandomData.generateRandomNonZeroNumberUpTo;

import static com.praxis.siho.test.common.util.RandomData.*;

public class ModuloAsignacionesSmokeTest extends WebDriverSetup {
	final String randomCve   = getRandomLetter(false) + getRandomLetter(true) + generateRandomNonZeroNumberUpTo(100);
	final String randomCve2  = getRandomLetter(false) + getRandomLetter(true) + generateRandomNonZeroNumberUpTo(100);
	final String descripcion = "A descripción";

	@Test(enabled = true, priority = 1, groups = {SMOKE, ASIGNACIONES}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
		testCase("signOn");
		LogInPage logInPage = new LogInPage(driver).refreshPage();
        Assert.assertNotNull(logInPage);
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);
        System.out.println("----------------SIGN ON COMPLETE---------------------");
    }
	
	@Test(enabled = true, priority = 2, groups = {SMOKE, ASIGNACIONES})
	public void casoAgregarLineaTecnologica() {
		testCase("casoAgregarLineaTecnologica");
		MainPage mainPage = new MainPage(driver).refreshPage();
		AsignacionLineaTecnologicaPage asigLineaTecnologicaPage = mainPage.linkToAsignacionLineaTecnologica();
        Assert.assertNotNull(asigLineaTecnologicaPage, "failed to load linea tecnologica asignacion");
        Assert.assertTrue(asigLineaTecnologicaPage.agregarLineaTecnologica(randomCve, descripcion), "error en el caso agregar linea tecnológica");
        System.out.println("----------------CASO AGREGAR LINEA TECNOLOGICA COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 3, groups = {SMOKE, ASIGNACIONES})
	public void casoEditarLineaTecnologica() {
		testCase("casoEditarLineaTecnologica");
		MainPage mainPage = new MainPage(driver).refreshPage();
		AsignacionLineaTecnologicaPage asigLineaTecnologicaPage = mainPage.linkToAsignacionLineaTecnologica();
		Assert.assertNotNull(asigLineaTecnologicaPage, "failed to load linea tecnologica asignacion");
       	asigLineaTecnologicaPage.editarLineaTecnologica(randomCve, descripcion + "A");
       	System.out.println("----------------CASO EDITAR LINEA TECNOLOGICA COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 4, groups = {SMOKE, ASIGNACIONES})
	public void casoBorrarLineaTecnologica() {
		testCase("casoBorrarLineaTecnologica");
		MainPage mainPage = new MainPage(driver).refreshPage();
		AsignacionLineaTecnologicaPage asigLineaTecnologicaPage = mainPage.linkToAsignacionLineaTecnologica();
        Assert.assertNotNull(asigLineaTecnologicaPage, "failed to load linea tecnologica asignacion");        
       	System.out.println(" about to do logical deletion");
        asigLineaTecnologicaPage.agregarLineaTecnologica(randomCve2, descripcion);     
       	asigLineaTecnologicaPage.refreshPage();
       	asigLineaTecnologicaPage.borrarLineaTecnologica(randomCve2);
       	System.out.println("----------------CASO BORRAR LINEA TECNOLOGICA COMPLETE---------------------");
	}

	@Test(enabled = true, priority = 5, groups = {SMOKE, ASIGNACIONES})
	public void casoAgregarTipoAsignacion(){
		testCase("casoAgregarTipoAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		TipoAsignacionPage asigTipoAsignacionPage = mainPage.linkToTipoAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load tipo asignacion");
        System.out.println("after tipo asignacion**************");                
        Assert.assertTrue(asigTipoAsignacionPage.agregarTipoAsignacion(randomCve, descripcion), "Error en el caso agregar tipo asignación");
       	System.out.println("----------------CASO AGREGAR TIPO ASIGNACION COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 6, groups = {SMOKE, ASIGNACIONES})
	public void casoEditarTipoAsignacion(){
		testCase("casoEditarTipoAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		TipoAsignacionPage asigTipoAsignacionPage = mainPage.linkToTipoAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load tipo asignacion");
        System.out.println("after tipo asignacion**************");                
        asigTipoAsignacionPage.editarTipoAsignacion(randomCve, descripcion + " Mod");
       	System.out.println("----------------CASO EDITAR TIPO ASIGNACION COMPLETE---------------------");
	}

	@Test(enabled = true, priority = 7, groups = {SMOKE, ASIGNACIONES})
	public void casoBorrarTipoAsignacion() throws InterruptedException{
		testCase("casoBorrarTipoAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		TipoAsignacionPage  asigTipoAsignacionPage = mainPage.linkToTipoAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load tipo asignacion");
        System.out.println("after tipo asignacion**************");       
        asigTipoAsignacionPage.agregarTipoAsignacion(randomCve2, descripcion);
        asigTipoAsignacionPage.borrarTipoAsignacion(randomCve2);
       	System.out.println("----------------CASO BORRAR TIPO ASIGNACION COMPLETE---------------------");            
	}

	@Test(enabled = true, priority = 8, groups = {SMOKE, ASIGNACIONES})
	public void casoAgregarEstatusAsignacion(){
		testCase("casoAgregarEstatusAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		EstatusAsignacionPage asigTipoAsignacionPage = mainPage.linkToEstatusAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load estatus asignacion");
        System.out.println("after estatus asignacion**************");                
        Assert.assertTrue(asigTipoAsignacionPage.agregarEstatusAsignacion(randomCve, "AAA"), "Error en el caso Agregar estatus Asignación");
       	System.out.println("----------------CASO AGREGAR ESTATUS ASIGNACION COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 9, groups = {SMOKE, ASIGNACIONES})
	public void casoEditarEstatusAsignacion(){
		testCase("casoEditarEstatusAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		EstatusAsignacionPage asigTipoAsignacionPage = mainPage.linkToEstatusAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load estatus asignacion");
        System.out.println("after estatus asignacion**************");                
        asigTipoAsignacionPage.editarEstatusAsignacion(randomCve, descripcion + " Mod");
       	System.out.println("----------------CASO EDITAR ESTATUS ASIGNACION COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 10, groups = {SMOKE, ASIGNACIONES})
	public void casoBorrarEstatusAsignacion(){
		testCase("casoBorrarEstatusAsignacion");
		MainPage mainPage = new MainPage(driver).refreshPage();
		EstatusAsignacionPage asigTipoAsignacionPage = mainPage.linkToEstatusAsignacion();
        Assert.assertNotNull(asigTipoAsignacionPage, "failed to load estatus asignacion");
        System.out.println("after estatus asignacion**************");
        asigTipoAsignacionPage.agregarEstatusAsignacion(randomCve2, "AAA");
        asigTipoAsignacionPage.borrarEstatusAsignacion(randomCve2);
       	System.out.println("----------------CASO BORRAR ESTATUS ASIGNACION COMPLETE---------------------");
	}

	@Test(enabled = true, priority = 11, groups = {SMOKE, ASIGNACIONES})
	public void casoConsultarProximosDesasignarse(){
		testCase("casoConsultarProximosDesasignarse");
		MainPage mainPage = new MainPage(driver).refreshPage();
		ProximoDesasignarsePage page = mainPage.linkToProximoDesasignarse();
		Assert.assertNotNull(page);
		System.out.println("about to run the check");
		Assert.assertNotNull(page.seleccionarRecursoAleatoriamente(), "Error para seleccionar recurso");
       	System.out.println("----------------CASO CONSULTAR PROXIMOS DESASIGNARSE COMPLETE---------------------");
	}
	
	@Test(enabled = true, priority = 12, groups = {SMOKE, ASIGNACIONES})
	public void casoConsultarProximosDesasignarseDia(){
		testCase("casoConsultarProximosDesasignarseDia");
		MainPage mainPage = new MainPage(driver).refreshPage();
		ProximoDesasignarsePage page = mainPage.linkToProximoDesasignarse();
		Assert.assertNotNull(page);
		System.out.println("about to run the check");
		Assert.assertNotNull(page.mostrarDesasignacionAcordeADias(), "Error para mostrar dias de proxima desasignacion");
       	System.out.println("----------------CASO CONSULTAR PROXIMOS DESASIGNARSE DIA COMPLETE---------------------");
	}

	@Test(enabled = false, priority = 13, groups = {SMOKE, ASIGNACIONES})
	public void casoAsignarCveProyectoRecurso(){
		testCase("casoAsignarCveProyectoRecurso");
		MainPage mainPage = new MainPage(driver).refreshPage();
		ConsultaAsignacionesPage consultaAsignacionesPage = mainPage.linkToConsultaAsignaciones();
		Assert.assertNotNull(consultaAsignacionesPage, "failed to load consultaAsignaciones");
		Assert.assertNotNull(consultaAsignacionesPage.asignarCveProyectoARecurso());
       	System.out.println("----------------CASO ASIGNAR CVE PROYECTO RECURSO COMPLETE---------------------");
	}
	
	@Test(enabled = false, priority = 14, groups = {SMOKE, ASIGNACIONES})
	public void casoAsignarCveProyectoInactivoRecurso(){
		testCase("casoAsignarCveProyectoInactivoRecurso");
		MainPage mainPage = new MainPage(driver).refreshPage();
		ConsultaAsignacionesPage consultaAsignacionesPage = mainPage.linkToConsultaAsignaciones();
		Assert.assertNotNull(consultaAsignacionesPage, "failed to load consultaAsignaciones");
		Assert.assertNotNull(consultaAsignacionesPage.asignarCveProyectoInactivoARecurso());
       	System.out.println("----------------CASO ASIGNAR CVE PROYECTO INACTIVO RECURSO COMPLETE---------------------");
	}
}
package com.praxis.siho.test.smoke;

import com.praxis.siho.test.WebDriverSetup;
import com.praxis.siho.test.dataprovider.SmokeTestDP;
import com.praxis.siho.test.pages.main.LogInPage;
import com.praxis.siho.test.pages.main.MainPage;
import com.praxis.siho.test.pages.main.horarios.ConsultaHorariosPage;
import com.praxis.siho.test.pages.main.horarios.ControlHorariosPage;
import com.praxis.siho.test.pages.main.horarios.PuntualidadAsistenciaPage;
import com.praxis.siho.test.pages.main.horarios.RegistroHorariosPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static com.praxis.siho.test.common.constants.GroupsConstants.*;

/**
 * Created by administrativo on 03/07/15.
 */
public class HorariosSmokeTest extends WebDriverSetup {

    @Test(enabled = true, priority = 1, groups = {SMOKE, HORARIOS}, dataProviderClass = SmokeTestDP.class, dataProvider = SIGNON)
    public void signOn(String credential, String password) {
        testCase("signOn");
        LogInPage logInPage = new LogInPage(driver).refreshPage();
        Assert.assertNotNull(logInPage);
        MainPage mainPage = logInPage.signon(credential, password);
        Assert.assertNotNull(mainPage);
        System.out.println("----------------CASO SIGN ON COMPLETE---------------------");
    }

    @Test(enabled = true, priority = 2, groups = {SMOKE, HORARIOS})
    public void casoRegistrarHorario(){
        testCase("casoRegistrarHorario");
        MainPage mainPage = new MainPage(driver).refreshPage();
        RegistroHorariosPage registroHorariosPage = mainPage.linkToRegistroHorariosPage();
        Assert.assertNotNull(registroHorariosPage);
        Assert.assertNotNull(registroHorariosPage.guardarHorarios());
        System.out.println("successful");
        System.out.println("----------------CASO REGISTRAR HORARIO COMPLETE---------------------");
    }

    @Test(enabled = true, priority = 3, groups = {SMOKE, HORARIOS})
    public void casoModificarHorario(){
        testCase("casoModificarHorario");
        MainPage mainPage = new MainPage(driver).refreshPage();
        ControlHorariosPage controlHorariosPage = mainPage.linkToControlHorariosPage();
        Assert.assertNotNull(controlHorariosPage);
        Assert.assertNotNull(controlHorariosPage.modificarHorario());
        System.out.println("----------------CASO MODIFICAR HORARIO COMPLETE---------------------");
    }
    
    @Test(enabled = true, priority = 4, groups = {SMOKE, HORARIOS})
    public void casoModificarHorasRegistradas(){
        testCase("casoModificarHorasRegistradas");
        MainPage mainPage = new MainPage(driver).refreshPage();
        PuntualidadAsistenciaPage puntualidadAsistenciaPage = mainPage.linkToPuntualidadAsistenciaPage();
        Assert.assertNotNull(puntualidadAsistenciaPage);
        Assert.assertNotNull(puntualidadAsistenciaPage.modificarHorasRegistradas());
        System.out.println("----------------CASO MODIFICAR HORAS REGISTRADAS COMPLETE---------------------");
    }

    @Test(enabled = true, priority = 5, groups = {SMOKE, HORARIOS})
    public void casoConsultarHorarios() {
        testCase("casoConsultarHorarios");
        boolean success = false;
        MainPage mainPage = new MainPage(driver).refreshPage();
        RegistroHorariosPage reghrsPage = mainPage.linkToRegistroHorariosPage();
        String fecha = reghrsPage.obtenerFechaConGuardadoHorario().get("fecha");
        ConsultaHorariosPage consultarHorariosPage = mainPage.linkToConsultaHorariosPage();
        Assert.assertNotNull(consultarHorariosPage);

        Map<String,String> messageResponse = consultarHorariosPage.consultarHorarios(fecha);
        if (messageResponse != null && !messageResponse.isEmpty()){
            System.out.println("horario aceptado? " + messageResponse.containsValue("Aceptado"));
        }
        //Assert.assertEquals(consultarHorariosPage.consultarHorarios(), consultarHorariosPage.SUCCESS);
        System.out.println("----------------CASO CONSULTAR HORARIOS COMPLETE---------------------");
    }
}

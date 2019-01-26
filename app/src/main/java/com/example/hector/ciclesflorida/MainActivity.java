package com.example.hector.ciclesflorida;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Titolacions.OnTitolacionsInteractionListener, TipusCicle.OnTCicleInteractionListener, Llistat.OnLlistatInteractionListener{
    ArrayList<CicleFlorida> llistat_titulacions;
    ArrayList<CicleFlorida> llistat_titulacions_empresa;
    ArrayList<CicleFlorida> llistat_titulacions_esports;
    ArrayList<CicleFlorida> llistat_titulacions_informatica;
    ArrayList<CicleFlorida> llistat_titulacions_mitja;
    ArrayList<CicleFlorida> llistat_titulacions_superior;
    FragmentManager fm;
    FragmentTransaction transaction;
    Fragment fTipusCicle;
    Fragment fLlistat;
    Titolacions fEstatic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llistat_titulacions = new ArrayList<CicleFlorida>();
        fm= getSupportFragmentManager();
        fEstatic = (Titolacions) fm.findFragmentById(R.id.fragment);

        creaDades();

        llistat_titulacions_empresa = new ArrayList<CicleFlorida>();
        llistat_titulacions_esports = new ArrayList<CicleFlorida>();
        llistat_titulacions_informatica = new ArrayList<CicleFlorida>();
        llistat_titulacions_mitja = new ArrayList<CicleFlorida>();
        llistat_titulacions_superior=new ArrayList<CicleFlorida>();
    }

    public void creaDades(){
        CicleFlorida c;


        c = new CicleFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        llistat_titulacions.add(c);
    }

    @Override
    public void buscarTitulacionsEmpresa() {
        buscarTitulacions(1);

    }

    @Override
    public void buscarTitulacionsInformatica() {
        buscarTitulacions(2);
    }

    @Override
    public void buscarTitulacionsEsports() {
        buscarTitulacions(3);
    }

    public void buscarTitulacions(int id){

        transaction=fm.beginTransaction();
        fTipusCicle=TipusCicle.newInstance(llistat_titulacions, id);
        transaction.replace(R.id.tipus_cicle, fTipusCicle);
        transaction.commit();
    }

    @Override
    public void onLlistatInteraction(Uri uri) {

    }

    @Override
    public void onTCicleInteraction(int id, ArrayList<CicleFlorida> arrayFiltrado) {
        transaction=fm.beginTransaction();
        fLlistat=Llistat.newInstance(arrayFiltrado, id);
        transaction.replace(R.id.llistat, fLlistat);
        transaction.commit();

    }
}

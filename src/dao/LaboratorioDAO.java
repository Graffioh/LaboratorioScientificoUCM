package dao;

import java.util.ArrayList;

import model.Laboratorio;

public interface LaboratorioDAO {

    String getLaboratorioBasedOnPersonale(int codPers);
    
    String getDescrizioneBasedOnPersonale(int codPers);
   
}

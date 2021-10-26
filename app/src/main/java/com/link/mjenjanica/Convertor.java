package com.link.mjenjanica;

public class Convertor {

    //method for converting euro to km
    public double euroToKm(double euro){
        if(euro == 0){
            return 0;
        }
        return euro * 1.94;
    }
    //method for converting km to euro
    public double kmToEuro(double km){
        if(km == 0){
            return 0;
        }
        return km / 1.94;
    }

    //method for converting dolar to km
    public double dolarToKm(double dolar){
        if(dolar == 0){
            return 0;
        }
        return dolar * 1.6;
    }

    //method for converting km to dolar
    public double kmToDolar(double km){
        if(km == 0){
            return 0;
        }
        return km / 1.6;
    }

    //method for converting krune to km
    public double svedKruneToKm(double svedKrune){
        if(svedKrune == 0){
            return 0;
        }
        return svedKrune * 0.18;
    }

    //method for converting km to krune
    public double kmToSvedKrune(double km){
        if(km == 0){
            return 0;
        }
        return km / 0.18;
    }

    //method for converting kune to km
    public double kuneToKm(double kune){
        if(kune == 0){
            return 0;
        }
        return kune / 4;
    }

    //method for converting km to krune
    public double kmToKune(double km){
        if(km == 0){
            return 0;
        }
        return km * 4;
    }

    //method for converting franac to km
    public double franacToKm(double franac){
        if(franac == 0){
            return 0;
        }
        return franac * 1.7;
    }

    //method for converting km to franac
    public double kmToFranac(double km){
        if(km == 0){
            return 0;
        }
        return km / 1.7;
    }

}

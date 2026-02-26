package com.pablocompany.practicano1_compi1.compiler.backend.recursos;

import com.pablocompany.practicano1_compi1.compiler.backend.clases.NodoDiagrama;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfigColor;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfigDefault;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfigFigura;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfigFondo;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfigSizeLetra;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfigTipoLetra;
import com.pablocompany.practicano1_compi1.compiler.models.configuracion.NodoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoConfiguracion;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoFigura;
import com.pablocompany.practicano1_compi1.compiler.models.enumsprogam.TipoLetra;

import java.util.List;

//Clase delegada para poder repartir las configuraciones indicadas para las instrucciones
public class GestorConfiguracion {

    //Atributos
    List<NodoConfiguracion> listaConfiguraciones;

    ConfiguracionPredeterminada configuracionPredeterminada;

    public GestorConfiguracion(List<NodoConfiguracion> listaConfiguraciones) {
        this.listaConfiguraciones = listaConfiguraciones;
        this.configuracionPredeterminada = new ConfiguracionPredeterminada();
    }

    //Metodo que permite retornarle al gestor principal la lista de todas las instrucciones
    public List<NodoDiagrama> setEstilos(List<NodoDiagrama> lista) {

        if (lista.isEmpty()) {
            return null;
        }

        darConfiguracionPredeterminada(lista);

        for (int i = 0; i < this.listaConfiguraciones.size(); i++) {
            NodoConfiguracion nodo = this.listaConfiguraciones.get(i);

            if (nodo instanceof NodoConfigDefault) {
                NodoConfigDefault nodoConfigDefault = (NodoConfigDefault) nodo;
                int nodoDefaul = nodoConfigDefault.getIndice();
                darConfiguracionDefault(nodoDefaul, lista);
            }
            else if (nodo instanceof NodoConfigColor) {
                NodoConfigColor nodoConfigColor = (NodoConfigColor) nodo;
                int indice = nodoConfigColor.getIndice();
                int color[] = nodoConfigColor.getColorConfig();
                darConfiguracionColorLetra(indice, lista, color);
            }
            else if (nodo instanceof NodoConfigFondo) {
                NodoConfigFondo nodoConfigFondo = (NodoConfigFondo) nodo;
                int indice = nodoConfigFondo.getIndice();
                int color[] = nodoConfigFondo.getColorConfig();
                darConfiguracionColorFondo(indice, lista, color);
            }
            else if (nodo instanceof NodoConfigTipoLetra){
                NodoConfigTipoLetra nodoConfigTipoLetra = (NodoConfigTipoLetra) nodo;
                int indice = nodoConfigTipoLetra.getIndice();
                TipoLetra tipoLetra = nodoConfigTipoLetra.getTipoLetra();
                darConfiguracionTipoLetra(indice, lista, tipoLetra);
            }
            else if (nodo instanceof NodoConfigFigura){
                NodoConfigFigura nodoConfigFigura = (NodoConfigFigura) nodo;
                int indice = nodoConfigFigura.getIndice();
                TipoFigura tipoFigura = nodoConfigFigura.getTipoFigura();
                darConfiguracionFigura(indice, lista, tipoFigura);

            }
            else if(nodo instanceof NodoConfigSizeLetra){
                NodoConfigSizeLetra nodoConfigSizeLetra = (NodoConfigSizeLetra) nodo;
                int indice = nodoConfigSizeLetra.getIndice();
                double size = nodoConfigSizeLetra.getSize();
                darConfiguracionSize(indice, lista, size);
            }

        }
        return lista;
    }

    //Submetodo que da configuracion de color de fondo a una instruccion
    private void darConfiguracionSize(int indice, List<NodoDiagrama> lista, double size) {

        for (int i = 0; i < lista.size(); i++) {
            NodoDiagrama nodo = lista.get(i);
            if (nodo.getSubIndice() == indice) {
                if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_SI) {
                    nodo.setSizeLetra(size);
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_MIENTRAS) {
                    nodo.setSizeLetra(size);
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_BLOQUE) {
                    nodo.setSizeLetra(size);
                    break;
                }
            }
        }

    }

    //Submetodo que da configuracion de color de fondo a una instruccion
    private void darConfiguracionFigura(int indice, List<NodoDiagrama> lista, TipoFigura figura) {

        for (int i = 0; i < lista.size(); i++) {
            NodoDiagrama nodo = lista.get(i);
            if (nodo.getSubIndice() == indice) {
                if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_SI) {
                    nodo.setFigura(figura);
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_MIENTRAS) {
                    nodo.setFigura(figura);
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_BLOQUE) {
                    nodo.setFigura(figura);
                    break;
                }
            }
        }

    }

    //Submetodo que da configuracion de color de fondo a una instruccion
    private void darConfiguracionTipoLetra(int indice, List<NodoDiagrama> lista, TipoLetra tipo) {

        for (int i = 0; i < lista.size(); i++) {
            NodoDiagrama nodo = lista.get(i);
            if (nodo.getSubIndice() == indice) {
                if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_SI) {
                    nodo.setTipoLetra(tipo);
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_MIENTRAS) {
                    nodo.setTipoLetra(tipo);
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_BLOQUE) {
                    nodo.setTipoLetra(tipo);
                    break;
                }
            }
        }

    }

    //Submetodo que da configuracion de color de fondo a una instruccion
    private void darConfiguracionColorFondo(int indice, List<NodoDiagrama> lista, int[] color) {

        for (int i = 0; i < lista.size(); i++) {
            NodoDiagrama nodo = lista.get(i);
            if (nodo.getSubIndice() == indice) {
                if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_SI) {
                    nodo.setColorFondo(getColor(color));
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_MIENTRAS) {
                    nodo.setColorFondo(getColor(color));
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_BLOQUE) {
                    nodo.setColorFondo(getColor(color));
                    break;
                }
            }
        }

    }

    //Submetodo que da configuracion de color de letra a una instruccion
    private void darConfiguracionColorLetra(int indice, List<NodoDiagrama> lista, int[] color) {

        for (int i = 0; i < lista.size(); i++) {
            NodoDiagrama nodo = lista.get(i);
            if (nodo.getSubIndice() == indice) {

                if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_SI) {
                    nodo.setColorTexto(getColor(color));
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_MIENTRAS) {
                    nodo.setColorTexto(getColor(color));
                    break;
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_BLOQUE) {
                    nodo.setColorTexto(getColor(color));
                    break;
                }
            }
        }

    }

    //Submetodo que permite dar configuracion default a las instrucciones busqueda por indice
    private void darConfiguracionDefault(int indice, List<NodoDiagrama> lista) {
        for (int i = 0; i < lista.size(); i++) {
            NodoDiagrama nodo = lista.get(i);
            if (nodo.getIndice() == indice) {

                if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_SI) {
                    estiloPredeterminadoSi(nodo);
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_MIENTRAS) {
                    estiloPredeterminadoMientras(nodo);
                } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_BLOQUE) {
                    estiloPredeterminadoBloque(nodo);
                }
                break;
            }
        }
    }

    /*METODO QUE PERMITE CONFIGURAR LAS FIGURAS DEL DIAGRAMA CON SU CONFIGURACION PREDETERMINADA*/
    private void darConfiguracionPredeterminada(List<NodoDiagrama> lista) {
        for (int i = 0; i < lista.size(); i++) {
            NodoDiagrama nodo = lista.get(i);

            if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_BLOQUE) {

                this.estiloPredeterminadoBloque(nodo);

            } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_MIENTRAS) {

                this.estiloPredeterminadoMientras(nodo);

            } else if (nodo.getTipoInstruccion() == TipoConfiguracion.INSTRUCCION_SI) {

                estiloPredeterminadoSi(nodo);

            } else {
                if (nodo.getTipoLetra() == null) {
                    nodo.setTipoLetra(TipoLetra.ARIAL);
                }
            }

        }

    }

    /*========REGION DE METODOS QUE PERMITEN DAR ESTILOS A LAS INSTRUCCIONES=========*/

    /*--------------------REGION QUE PERMITE DAR ESTILOS A LAS INSTRUCCIONES PERSONALIZADAS--------------------*/



    /*--------------------FIN DE LA REGION QUE PERMITE DAR ESTILOS A LAS INSTRUCCIONES PERSONALIZADAS--------------------*/


    /*-------REGION DE METODOS QUE PERMITEN DAR ESTILOS A LAS INSTRUCCIONES POR PREDETERMINADO-------*/

    private void estiloPredeterminadoSi(NodoDiagrama nodo) {
        nodo.setFigura(configuracionPredeterminada.getFiguraSi());
        nodo.setColorFondo(getColor(configuracionPredeterminada.getRgbSiFondo()));
        nodo.setColorTexto(getColor(configuracionPredeterminada.getRgbSiLetra()));
        nodo.setSizeLetra(configuracionPredeterminada.getSizeSi());
        nodo.setTipoLetra(configuracionPredeterminada.getLetraSi());
    }

    private void estiloPredeterminadoMientras(NodoDiagrama nodo) {
        nodo.setFigura(configuracionPredeterminada.getFiguraMientras());
        nodo.setColorFondo(getColor(configuracionPredeterminada.getRgbMientrasFondo()));
        nodo.setColorTexto(getColor(configuracionPredeterminada.getRgbMientrasLetra()));
        nodo.setSizeLetra(configuracionPredeterminada.getSizeMientras());
        nodo.setTipoLetra(configuracionPredeterminada.getLetraMientras());
    }

    private void estiloPredeterminadoBloque(NodoDiagrama nodo) {
        nodo.setFigura(configuracionPredeterminada.getFiguraBloque());
        nodo.setColorFondo(getColor(configuracionPredeterminada.getRgbBloqueFondo()));
        nodo.setColorTexto(getColor(configuracionPredeterminada.getRgbBloqueLetra()));
        nodo.setSizeLetra(configuracionPredeterminada.getSizeBloque());
        nodo.setTipoLetra(configuracionPredeterminada.getLetraBloque());
    }

    /*-------FIN DE LA REGION DE METODOS QUE PERMITEN DAR ESTILOS A LAS INSTRUCCIONES POR PREDETERMINADO-------*/




    /*========FIN DE LA REGION DE METODOS QUE PERMITEN DAR ESTILOS A LAS INSTRUCCIONES=========*/

    /*METODO QUE PERMITE OBTENER EL ARREGLO RGB DE LOS COLORES*/
    int getColor(int[] rgb) {

        int color = android.graphics.Color.rgb(
                rgb[0],
                rgb[1],
                rgb[2]);

        return color;

    }


}

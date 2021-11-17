package Act2;

import java.util.concurrent.Semaphore;

public class Libro {
  private Semaphore semEscritor;
  private Semaphore semLector;
  private Semaphore mutexHojasEscritas, mutexHojasTotales, mutexCantLect;
  private Semaphore semNuevaHoja;
  private int cantLectores,lectsEsp;
  private int cantEscritores;
  private int cantHojasEscritas;
  private int cantHojasTotales;

  public Libro(int cantHojasTotales) {
    this.semLector = new Semaphore(1);
    this.semEscritor = new Semaphore(1);
    this.mutexCantLect = new Semaphore(1);
    this.mutexHojasEscritas = new Semaphore(1);
    this.mutexHojasTotales = new Semaphore(1);

    lectsEsp = 0;
    this.cantEscritores = 0;
    this.cantLectores = 0;
    this.cantHojasTotales = cantHojasTotales;
    this.cantHojasEscritas = 0;
  }

  public boolean empezarLectura(int hojasLeidas) {
    boolean yaLeyoTodo = false;
        if (hayEscrito(hojasLeidas)) {
            // el lector verifica que haya hojas nuevas para leer
            // obtiene el semaforo de lector para que no pueda acceder otro lector o
            // escritor

            if (cantLectores == 0) {
              try {
                semLector.acquire();
              } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
              }
            }

            System.out.println(Thread.currentThread().getName() + " esta leyendo");
            // sumamos un lector a la cantidad de lectores
            this.cantLectores++;
        } else {
            // si no hay hojas nuevas por leer verificamos si ya se termino de escribir el
            // libro
            /*
            Una var que cuentes cuantos lectores estan esperando.Si cuando se termina de escribir una hoja,
            si hay lectores esperando hoja nueva,se libera de a 1 a 1.El ultimo lector en pasar no libera ningun 
            permiso.
            */
            if (leyoTodo(hojasLeidas)) {
                System.out.println(Thread.currentThread().getName() + " dice: \"ya leí todo el libro \"");
                System.out.println(hojasLeidas+" - "+cantHojasTotales);
                yaLeyoTodo = true;
            }
        }
        return yaLeyoTodo;
  }

  public boolean empezarEscritura() {
    boolean seEscribioTodo = false;
    try {
      semLector.acquire();
      semEscritor.acquire();
      System.out.println(Thread.currentThread().getName() + " toma el libro.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (!finalizado()) {
      // si todavia no se escribieron la cantidad de hojas deseadas
      System.out.println(Thread.currentThread().getName() + " esta escribiendo");
      this.cantEscritores++;
    } else {
      semLector.release();
      semEscritor.release();
      System.out.println(Thread.currentThread().getName() + " dice: \"ya se escribio todo el libro\"");
      seEscribioTodo = true;
    }
    return seEscribioTodo;
  }

  public void finalizarLectura() {
    // simplemente terminamos de leer, por eso hacemos un release al semaforo de
    // lector
    try {
      mutexCantLect.acquire();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    this.cantLectores--;
    mutexCantLect.release();

    if (cantLectores == 0) {
      semLector.release();
    }
  }

  public void finalizarEscritura() {
    // Este metodo solamente agrega una hoja a la cantidad de hojas del libro
    // (porque el escritor la acaba de redactar)

    try {
      mutexHojasEscritas.acquire();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    this.cantHojasEscritas++;
    mutexHojasEscritas.release();

    this.cantEscritores--;
    // indicamos que ha terminado de escribir
    System.out.println(Thread.currentThread().getName() + " terminó de escribir hoja nro " + cantHojasEscritas);
    // liberamos los semaforos para que pueda acceder un escritor o un lector
    semLector.release();
    semEscritor.release();
  }

  public boolean hayEscrito(int hojasLeidas) {
    boolean res;

    try {
      mutexHojasEscritas.acquire();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    res = hojasLeidas < cantHojasEscritas;

    mutexHojasEscritas.release();

    return res;
  }

  public boolean leyoTodo(int hojasLeidas) {
    boolean res;

    try {
      mutexHojasTotales.acquire();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    res = hojasLeidas == cantHojasTotales && cantHojasTotales != 0;

    mutexHojasTotales.release();

    return res;
  }

  public boolean finalizado() {
    boolean res;

    try {
      mutexHojasEscritas.acquire();
      mutexHojasTotales.acquire();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    res = cantHojasEscritas >= cantHojasTotales;

    mutexHojasEscritas.release();
    mutexHojasTotales.release();

    return res;
  }
}

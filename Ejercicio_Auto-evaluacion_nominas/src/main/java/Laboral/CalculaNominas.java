package Laboral;

public class CalculaNominas {

    public static void main(String[] args) {
        try {
            Empleado e1 = new Empleado("James Coslng", "48811600B", 'M', 4, 7);
            Empleado e2 = new Empleado("Ada Lovelace", "48814047C", 'F');
            escribe(e1, e2);

            e2.incrAnyo();
            e1.setCategoria(9);
            escribe(e1, e2);
        } catch (DatosNoCorrectosException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void escribe(Empleado e1, Empleado e2) {
        System.out.println(e1.imprime() + " - Sueldo=" + Nomina.sueldo(e1));
        System.out.println(e2.imprime() + " - Sueldo=" + Nomina.sueldo(e2));
    }

//Parte 2
    public static void main(String[] args) {
        try {
            File fentrada = new File("empleados.txt");
            FileReader fr = new FileReader(fentrada);
            BufferedReader br = new BufferedReader(fr);

            File fentradaActualizada = new File("empleadosActualizados.txt");
            FileWriter fw = new FileWriter(fentradaActualizada);
            BufferedWriter bw = new BufferedWriter(fw);

            File fsalida = new File("salarios.dat");
            FileOutputStream fos = new FileOutputStream(fsalida);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            OutputStreamWriter bos = new OutputStreamWriter(fos);

            String line;;
            Empleado e;
            String[] datosEmp;

            while (br.ready()) {
                line = br.readLine();
                datosEmp = line.split(";");
                if (datosEmp.length == 3) {
                    e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0]);
                } else {
                    e = new Empleado(datosEmp[0], datosEmp[1], datosEmp[2].toCharArray()[0], Integer.parseInt(datosEmp[3]), Integer.parseInt(datosEmp[4]));
                }

                escribeEmp(e);

                bos.write((e.dni + ";" + Nomina.sueldo(e) + '\n').getBytes());
                bos.write(e.dni + ";" + Nomina.sueldo(e) + '\n');

                if (e.nombre.equalsIgnoreCase("James Cosling")) {
                    e.setCategoria(9);
                } else if (e.nombre.equalsIgnoreCase("Ada Lovealace")) {
                    e.incrAnyo();
                }

                bw.write(e.nombre + ";" + e.dni + ";" + e.sexo + ";" + e.getCategoria() + ";" + e.anyos + '\n');
            }

            br.close();
            bos.close();
            bw.close();

            fentrada.delete();
            fentradaActualizada.renameTo(fentrada);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DatosNoCorrectosException e) {
            e.printStackTrace();
        }
    }
}

private static void escribeEmp(Empleado e1) {
    	System.out.println(e1.imprime() +  " - Sueldo="+ Nomina.sueldo(e1));
    }
	
}

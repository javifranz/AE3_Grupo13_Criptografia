package aplicacion;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;



public class Aplicacion {
	
	public static void main (String args[]) throws IOException  {
		
		
		
		System.out.println(" --- Sistema de encriptacion --- ");
		
		
		
		try (Scanner sc0 = new Scanner(System.in)) { //Este Scanner lo usaremos para la variable opcion
			boolean continuar = true;
			
			String mensajeOriginal;
	        String mensajeEncriptado;
			
			do {
				
				int opcion = 0;
				System.out.println("¿Que desea hacer?: \n 0. Salir \n "
						+ "1. Encriptar frase \n " 
						+ "2. Desencriptar frase \n ");
				opcion = sc0.nextInt();
				
			      KeyGenerator generador = KeyGenerator.getInstance("AES"); //Generador de claves
			      SecretKey paloEspartano = generador.generateKey(); // Clave simétrica
			      Cipher cifrador = Cipher.getInstance("AES"); //Objeto para encriptar y desencriptar
			      cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano); //El cifrador encriptará
			      Cipher descifrador = Cipher.getInstance("AES");
			      descifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
			     
                 
			      
				switch(opcion) {
				
				case 0:
		
					System.out.println("La aplicacion se ha detenido");
					continuar = false;
					break;
					
				case 1:	
			
			      Scanner sc1 = new Scanner (System.in);
	
			
			      System.out.println("Introduzca la frase que desea encriptar");		
			
			      mensajeOriginal = sc1.nextLine();
			      byte[] bytesMensajeOriginal = mensajeOriginal.getBytes(); //Convertimos a bytes 1de2
			      byte[] bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal); //Convertimos a bytes 2de2
			      String mensajeCifrado = new String(bytesMensajeCifrado);
			     
			      
			      System.out.println("Mensaje Cifrado: " + mensajeCifrado);
			      System.out.println("Mensaje Original: " + mensajeOriginal);
			      break;
			
				case 2:
			    
                  
					

				}
				
				
				
			}while (continuar);
				
		//Simplificamos las excepciones capturando GeneralSecurityException
		} catch (GeneralSecurityException gse) {
			System.out.println("Algo ha fallado.." + gse.getMessage());
			gse.printStackTrace();
		}
		

		}
	

	}
	



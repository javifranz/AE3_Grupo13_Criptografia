package aplicacion;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import javax.crypto.SecretKey;


public class Aplicacion {
	
	public static void main (String args[]) throws IOException, NoSuchAlgorithmException  {
		
		Scanner sc = new Scanner(System.in);
		
		//meter iobjetos usuario
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		Usuario usuario1 = new Usuario ("usu1", "Tf9Oo0DwqCPxXT9PAati6uDl2lecy4Ufjbnf6ExYsrN7iZA6dA4e4XLaeTpuedVg5ff5vQWKEqKAQz7W+kZRCg==");
		Usuario usuario2 = new Usuario ("usu2", "QLJEESZB3XjdT5O2yRkN1G4AmRlNWkQle3761u+f9Gg9oe2gJERIyzQ6poj10+/XMU2v5YCsC8vxFa7Kno3BFA==");
		Usuario usuario3 = new Usuario ("usu3", "O6+/CIgqLRATMJOhuEM/UFY7k8FKzQW3kCjrHRJ5kCckFFCYBlGZRQFCOmbCdq4mxDtzm8ZcThaxDDr2wgKuuw==");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		int contInt=1;
		 
		
		
		do {
		
		
		
		
		String nombreUsu="";
		String passUsu = "";
		String passUsuHash= "";
		
		
		
		System.out.println("Introduzca nombre de usuario: ");
		
		nombreUsu= sc.nextLine();
		
		System.out.println("Introduzca contraseña: ");
		
		passUsu= sc.nextLine();
				
			
	
		
		byte[] pass1 = passUsu.getBytes();
		
		MessageDigest md1 = MessageDigest.getInstance("SHA-512");
		md1.update(pass1);
		
		//creando hash

		byte[] hashed = md1.digest();
		
		passUsuHash = new String (hashed);
		
		
		String passHash64 = Base64.getEncoder().encodeToString(hashed);
		
		
		System.out.println(passHash64);
		
		for (int i=0; i<usuarios.size(); i++) {
			
		
		
			if (nombreUsu.equals(usuarios.get(i).getNombre())) {
				
				
				System.out.println(usuarios.get(i).getNombre() + " encontrado!");
				
				if (passHash64.equals(usuarios.get(i).getPassHash())) {
					
					System.out.println(usuarios.get(i).getNombre() + " contraseña correcta");
					
					
					System.out.println(" --- Sistema de encriptacion --- ");
					try {
					
					KeyGenerator generador = KeyGenerator.getInstance("AES");
					System.out.println("Paso 1: Se ha obtenido el generador de claves");
					
					SecretKey paloEspartano = generador.generateKey();
					System.out.println("Paso 2: Se ha obtenido la clave");

					Cipher cifrador = Cipher.getInstance("AES");
					System.out.println("Paso 3: Hemos obtenido el descifrador");
					
						
						
					
						
						
						
						boolean continuar = true;
						
						byte[] bytesMensajeOriginal;
						byte[] bytesMensajeCifrado =null;
						
						String mensajeOriginal;
						String mensajeCifrado ;
						
						
						do {
							
							
							
							Scanner sc0 = new Scanner(System.in);
						
							
							int opcion = 0;
							System.out.println("¿Que desea hacer?: \n 0. Salir \n "
									+ "1. Encriptar frase \n " 
									+ "2. Desencriptar frase \n ");
							opcion = sc0.nextInt();
								
				
						      
							switch(opcion) {
							
							case 0:
					
								System.out.println("La aplicacion se ha detenido");
								continuar = false;
								break;
								
							case 1:	
								
								System.out.println("Probando sistema de encriptaci�n con algoritmo AES");
								
								try {
									
									
									
									//Ahora el cifrador lo configuramos para que use la clave simetrica
									//para encriptar
									cifrador.init(Cipher.ENCRYPT_MODE, paloEspartano);
									System.out.println("Paso 4: Hemos configurado el cifrador");
									
									System.out.println("Inserte frase a codificar: ");
											sc0.nextLine();
									mensajeOriginal = sc0.nextLine();
									//El cifrador trabaja con bytes, lo convertimos
									bytesMensajeOriginal = mensajeOriginal.getBytes();
									System.out.println("Paso 5.1: Ciframos el mensaje original");
									//El cifrador devuelve una cadena de bytes
									bytesMensajeCifrado = cifrador.doFinal(bytesMensajeOriginal);
									mensajeCifrado = new String(bytesMensajeCifrado);
									System.out.println("Paso 5.2: Mensaje Original: " + mensajeOriginal);
									System.out.println("Paso 5.3: Mensaje Cifrado: " + mensajeCifrado);
									
									
								//Simplificamos las excepciones capturando GeneralSecurityException
								} catch (GeneralSecurityException gse) {
									System.out.println("Algo ha fallado.." + gse.getMessage());
									gse.printStackTrace();
								}
								break;
						
							case 2:
							try {
								
								System.out.println("Paso 6.1: Desciframos el criptograma:");
								//Ahora el cifrador lo configuramos para que use la clave simetrica
								//para desencriptar. Debemos de usar la MISMA clave para descifrar, NO
								//PODEMOS usar/generar una diferente.
								cifrador.init(Cipher.DECRYPT_MODE, paloEspartano);
								byte[] bytesMensajeDescifrado = cifrador.doFinal(bytesMensajeCifrado);
								System.out.println("Paso 6.2: Mensaje Descifrado: " + new String(bytesMensajeDescifrado));
						
							}catch (GeneralSecurityException gse) {
								System.out.println("Algo ha fallado.." + gse.getMessage());
								gse.printStackTrace();
							}
								
							break;
							
							
							
							}	
							
						}while (continuar);
							
						
				
					
				} catch (Exception gse) {
					System.out.println("Algo ha fallado.." + gse.getMessage());
					gse.printStackTrace();
				}
			
					
				}else {System.out.println("Usuario o contraseña incorrectas, "
						+ "vuelva a intentarlo. Intento "+ contInt+"/3");
				contInt++;
			
	}
					
				}else {System.out.println(".");}
					
			
		
				
	
		}
	
	
		}while (contInt<=3);
}
}


		
	

	
	



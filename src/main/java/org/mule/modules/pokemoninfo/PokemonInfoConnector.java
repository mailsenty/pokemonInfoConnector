package org.mule.modules.pokemoninfo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;

import org.mule.modules.pokemoninfo.config.ConnectorConfig;

@Connector(name="pokemon-info", friendlyName="PokemonInfo")
public class PokemonInfoConnector {

    @Config
    ConnectorConfig config;

private final String POKEMON = "http://pokeapi.co/api/v2/";

private final String USER_AGENT = "Mozilla/5.0";
	
   	private  URL url;


   	HttpURLConnection con ;

       
       public ConnectorConfig getConfig() {
           return config;
       }

       public void setConfig(ConnectorConfig config) {
           this.config = config;
       }
       
       

       @Processor
       public String searchOnAbility(String level) {
           String response;
       	try {
       		
       		String reqStr=POKEMON+"ability/"+level+"/";
       		
       		url  = new URL(reqStr);
      	response=processConnection(url);
   		} catch (MalformedURLException e) {
   			response="Error connecting to endpoint Please retry";
   			e.printStackTrace();
   		}
       	catch (Exception e) {
       		response="Error connecting to endpoint Please retry" ;  				
   			e.printStackTrace();
   		}
       	return response;
     

       }
       
       @Processor
       public String searchOnType(String typelevel) {
           String response;
       	try {
       		
       		String reqStr=POKEMON+"type/"+typelevel+"/";
       		
       		url  = new URL(reqStr);
      	response=processConnection(url);
   		} catch (MalformedURLException e) {
   			response="Error connecting to endpoint Please retry";
   			e.printStackTrace();
   		}
       	catch (Exception e) {
       		response="Error connecting to endpoint Please retry" ;  				
   			e.printStackTrace();
   		}
       	return response;
     

       }
       
       private String processConnection(URL url){
       	
       	StringBuffer response = new StringBuffer();
       	
       	try {
   			con = (HttpURLConnection) url.openConnection();
   			con.setRequestProperty("User-Agent", USER_AGENT);
   			
   			con.setRequestMethod("GET");

   			// add request header
   			int responseCode = con.getResponseCode();
   			System.out.println("\nSending 'GET' request to URL : " + url);
   			System.out.println("Response Code : " + responseCode);

   			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
   			String inputLine;
   			

   			while ((inputLine = in.readLine()) != null) {
   				response.append(inputLine);
   			}
   			in.close();
   		}  catch (Exception e) {
   			response=new StringBuffer("Error getting Yoda Speak");
   			e.printStackTrace();
   		}

   		// print result
   		return response.toString();
       }

}
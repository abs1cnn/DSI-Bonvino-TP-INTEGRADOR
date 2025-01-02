package Boundarys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import Clases.*;
import org.json.JSONArray;
import org.json.JSONObject;
import com.company.PantallaAB.PantallaAB;

public class InterfazSB {
	ArrayList<String> bodegasSinConexion = new ArrayList<>();
	public ArrayList<Vino> getImportarActualizacionVinos(String bodegaSeleccionadas) {
		String bodegaSeleccionadasConGuiones = bodegaSeleccionadas.replace(" ", "-");
		String urlStr = "http://localhost:8080/" + bodegaSeleccionadasConGuiones;
		ArrayList<Vino> vinoData = new ArrayList<>();

		try {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			StringBuilder sb = new StringBuilder();
			String output;
			while ((output = br.readLine()) != null) {
				sb.append(output);
			}

			conn.disconnect();

			// Process the JSON response
			JSONArray jsonArray = new JSONArray(sb.toString());

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				Vino vino = new Vino();
				vino.setAniada(jsonObject.optInt("aniada"));
				vino.setImagenEtiqueta(jsonObject.optString("imagenEtiqueta"));
				vino.setNombre(jsonObject.optString("nombre"));
				vino.setNotaDeCataBodega(jsonObject.optString("notaDeCataBodega"));
				vino.setPrecioARS(jsonObject.optDouble("precioARS"));
				JSONObject bodegaJsonObject = jsonObject.optJSONObject("bodega");
				Bodega bodega = new Bodega();
				if (bodegaJsonObject != null) {
					bodega.setCoordenadasUbicacion(bodegaJsonObject.optString("coordenadasUbicacion"));
					bodega.setDescripcion(bodegaJsonObject.optString("descripcion"));
					bodega.setHistoria(bodegaJsonObject.optString("historia"));
					bodega.setNombreBodega(bodegaJsonObject.optString("nombre"));
					bodega.setPeriodoActualizacion(bodegaJsonObject.optInt("periodoActualizacion"));
					bodega.setUltimaActualizacion(bodegaJsonObject.optString("ultimaActualizacion"));
				}
				vino.setBodega(bodega);
				JSONArray reseniasJsonArray = jsonObject.optJSONArray("resenia");
				ArrayList<Resenia> reseniasList = new ArrayList<>();
				if (reseniasJsonArray != null) {
					for (int j = 0; j < reseniasJsonArray.length(); j++) {
						JSONObject reseniaJsonObject = reseniasJsonArray.getJSONObject(j);
						Resenia reseniaIndividual = new Resenia();
						reseniaIndividual.setComentario(reseniaJsonObject.optString("comentario"));
						reseniaIndividual.setEsPremium(reseniaJsonObject.optBoolean("esPremium"));
						reseniaIndividual.setFechaResenia(reseniaJsonObject.optString("fechaResenia"));
						reseniaIndividual.setPuntaje(reseniaJsonObject.optInt("puntaje"));
						reseniasList.add(reseniaIndividual);
					}
				}
				JSONArray varietalJsonArray = jsonObject.optJSONArray("varietal");
				ArrayList<Varietal> varietalesList = new ArrayList<>();
				if (varietalJsonArray != null) {
					for (int k = 0; k < varietalJsonArray.length(); k++) {
						JSONObject varietalJsonObject = varietalJsonArray.getJSONObject(k);
						Varietal varietalIndividual = new Varietal();
						varietalIndividual.setDescripcion(varietalJsonObject.optString("descripcion"));
						varietalIndividual.setPorcentajeComposicion(varietalJsonObject.optDouble("porcentajeComposicion"));
						JSONObject tipoUvaJsonObject = varietalJsonObject.optJSONObject("tipoUva");
						TipoUva tipoUva = new TipoUva();
						if (tipoUvaJsonObject != null) {
							tipoUva.setNombre(tipoUvaJsonObject.optString("nombre"));
							tipoUva.setDescripcion(tipoUvaJsonObject.optString("descripcion"));
						}
						varietalIndividual.setTipoUva(tipoUva);
						varietalesList.add(varietalIndividual);
					}
				}
				vino.setResenia(reseniasList);
				vino.setVarietal(varietalesList);
				JSONArray maridajesJsonArray = jsonObject.optJSONArray("maridaje");
				ArrayList<Maridaje> maridajesList = new ArrayList<>();
				if (maridajesJsonArray != null) {
					for (int l = 0; l < maridajesJsonArray.length(); l++) {
						JSONObject maridajeJsonObject = maridajesJsonArray.getJSONObject(l);
						Maridaje maridajeIndividual = new Maridaje();
						maridajeIndividual.setNombre(maridajeJsonObject.optString("nombre"));
						maridajeIndividual.setDescripcion(maridajeJsonObject.optString("descripcion"));
						maridajesList.add(maridajeIndividual);

					}
				}
				vino.setMaridaje(maridajesList);
				vinoData.add(vino);
			}

			return vinoData;
		} catch (IOException e) {

		} catch (Exception e) {

			bodegasSinConexion.add(bodegaSeleccionadas);
			PantallaAB.tablaBodegasSinConexion( bodegasSinConexion);
		}
		ArrayList<Vino> emptyList = new ArrayList<>();
		return emptyList;
	}
}

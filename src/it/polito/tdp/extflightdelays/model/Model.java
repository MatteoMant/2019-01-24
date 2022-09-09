package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private ExtFlightDelaysDAO dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
	}
	
	public void creaGrafo() {
		grafo = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		
		// Aggiunta dei vertici
		Graphs.addAllVertices(this.grafo, dao.loadAllStates());
		
		// Aggiunta degli archi
		for (Adiacenza a : dao.getAllAdiacenze()) {
			Graphs.addEdge(this.grafo, a.getStato1(), a.getStato2(), a.getPeso());
		}
		
	}
	
	public List<Adiacenza> getStatiConnessi(String stato) {
		List<Adiacenza> result = new LinkedList<>();
		
		for (String s : Graphs.successorListOf(this.grafo, stato)) {
			result.add(new Adiacenza(stato, s, (int)this.grafo.getEdgeWeight(this.grafo.getEdge(stato, s))));
		}
		Collections.sort(result);
		return result;
	}
	
	public List<String> getAllVertici() {
		return new ArrayList<>(this.grafo.vertexSet());
	}
	
	public int getNumVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int getNumArchi() {
		return this.grafo.edgeSet().size();
	}
	
}

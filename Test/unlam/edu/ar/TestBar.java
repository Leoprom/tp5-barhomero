package unlam.edu.ar;

import static org.junit.Assert.*;

import java.util.TreeSet;

import org.junit.Test;

public class TestBar {

	@Test
	public void queElBarEsteAbierto() {
		Bar miBar = new Bar();
		
		miBar.abrirBar();
		
		assertTrue(miBar.barAbierto());
	}

	@Test
	public void queEntrenClientesDeIgualNombre(){
		Bar miBar = new Bar();
		
		miBar.ingresarCliente(new Cliente("Prom", 22));
		miBar.ingresarCliente(new Cliente("Gambra", 21));
		miBar.ingresarCliente(new Cliente("Sam", 42));
		miBar.ingresarCliente(new Cliente("Prom", 15));
		miBar.ingresarCliente(new Cliente("Dust", 27));
		
		assertEquals(miBar.getClientes().size(), 4);
	}
	
	@Test
	public void clientesOrdenadosPorNombre(){
		Bar miBar = new Bar();
		
		miBar.ingresarCliente(new Cliente("Prom", 22));
		miBar.ingresarCliente(new Cliente("Gambra", 21));
		miBar.ingresarCliente(new Cliente("Sam", 42));
		miBar.ingresarCliente(new Cliente("Prom", 15));
		miBar.ingresarCliente(new Cliente("Dust", 27));
		
		assertEquals(miBar.getClientes().first().getNombre(), "Dust");
		assertEquals(miBar.getClientes().last().getNombre(), "Sam");
	}
		
	@Test
	public void clientesOrdenenadosPorEdad(){
		ComparadorEdad comparador = new ComparadorEdad();
		Bar miBar = new Bar();
		
		miBar.ingresarCliente(new Cliente("Prom", 21));
		miBar.ingresarCliente(new Cliente("Gambra", 21));
		miBar.ingresarCliente(new Cliente("Sam", 42));
		miBar.ingresarCliente(new Cliente("Prom", 15));
		miBar.ingresarCliente(new Cliente("Dust", 27));
		
		TreeSet <Cliente> clientesPorEdad = new TreeSet <Cliente>(comparador);
		clientesPorEdad.addAll(miBar.getClientes());
		miBar.setClientes(clientesPorEdad);
		
		assertEquals("Gambra", miBar.getClientes().first().getNombre());
		assertEquals("Sam", miBar.getClientes().last().getNombre());
	}
	
	@Test
	public void queSeComparaenClientesPorNombre(){
		Cliente miCliente1 = new Cliente("Prom", 22);
		Cliente miCliente2 = new Cliente("Prom", 15);
		Cliente miCliente3 = new Cliente("Dust", 27);
		
		assertEquals(miCliente1.compareTo(miCliente2), 0);
		assertNotEquals(miCliente1.compareTo(miCliente3), 0);
	}

}


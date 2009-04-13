package br.faculdadeidez.psa.tests;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import br.faculdadeidez.psa.businesslogic.ViaturaBusinessLogic;
import br.faculdadeidez.psa.vo.ViaturaVO;

public class testViaturaBusinessLogic extends TestCase {

	private ViaturaVO v;
	private ViaturaBusinessLogic vbl = new ViaturaBusinessLogic();
	private ArrayList<ViaturaVO> listViaturasValidas = new ArrayList<ViaturaVO>();
		
	protected void setUp() throws Exception {
		this.listViaturasValidas.add(new ViaturaVO("1234",false, false));
		this.listViaturasValidas.add(new ViaturaVO("1235",true, true));
	}
	
	public void testCreateValidos() {
		/**
		 * Test case - TC1.1.1 - Valores V�lidos
		 **/
		assertEquals("inserido", vbl.create(this.listViaturasValidas.get(0)));
		assertEquals("inserido", vbl.create(this.listViaturasValidas.get(1)));
	}
	
	public void testCreateNulos() {
		/**
		 * Test case - TC1.1.2 - Valores Nulos
		 **/
		
		// codigo nulo
		v = new ViaturaVO(null,false, false);
		assertEquals("problemaInserir", vbl.create(v));

		// ocupada nulo
		v.setCodigo("5555");
		v.setOcupada(null);
		assertEquals("problemaInserir", vbl.create(v));
	}
	
	public void testCreateValoresExistentes() {
		/**
		 * Test case - TC1.1.3 - Valores Existentes
		 **/
		// codigo duplicado
		v = new ViaturaVO("1234",false, false);
		assertEquals("viaturaExistente", vbl.create(v));
	}
	
	public void testCreateInvalidos() {
		/**
		 * Test case - TC1.1.4
		 **/
		// codigo inv�lido
		// string vazia
		v = new ViaturaVO("",false, false);
		assertEquals("O c�digo � obrigat�rio, ", vbl.create(v));

		// string.length > 4
		v.setCodigo("12345");
		assertEquals("O c�digo deve ser menor que 4 d�gitos, ", vbl.create(v));
		
		// caracteres especiais
		v.setCodigo("#$%*");
		assertEquals("O c�digo deve ser apenas d�gitos, ", vbl.create(v));
		
	}
	
	public void testDelete() {
		assertEquals("removido", vbl.delete(listViaturasValidas.remove(1)));
		v = new ViaturaVO("9999",false, false);
		assertEquals("viaturaInexistente", vbl.delete(v));
	}

	public void testUpdate() {
		List<ViaturaVO> ls;

		{
			/**
			 * Test case - TC1.3.1
			 **/
			ls = vbl.pesquisar("1234");
			v = ls.get(0);
			assertEquals("atualizado", vbl.update(v));

		}

		{
			/**
			 * Test case - TC1.3.2
			 **/
			ls = vbl.pesquisar("9999");
			if (ls.isEmpty())
				v = null;
			assertEquals("viaturaInexistente", vbl.update(new ViaturaVO("9999",false, false)));
		}

		{
			/**
			 * Test case - TC1.3.3
			 **/

			ls = vbl.pesquisar("1234");
			v = ls.get(0);

			// codigo nulo
			v.setCodigo(null);
			assertEquals("problemaAtualizar", vbl.update(v));

			// ocupada nulo
			v.setCodigo("1234");
			v.setOcupada(null);
			assertEquals("problemaAtualizar", vbl.update(v));
		}

		{
			/**
			 * Test case - TC1.3.5
			 **/

			ls = vbl.pesquisar("1234");
			v = ls.get(0);

			// codigo inv�lido
			// string vazia
			v.setCodigo("");
			assertEquals("O c�digo � obrigat�rio, ", vbl.update(v));

			// codigo inv�lido
			// string.length > 4
			v.setCodigo("12345");
			assertEquals("O c�digo deve ser menor que 4 d�gitos, ", vbl.create(v));
			
			// codigo inv�lido			
			// caracteres especiais
			v.setCodigo("#$%&");
			assertEquals("O c�digo deve ser apenas d�gitos, ", vbl.update(v));
		}
	}
	
	public void testListar() {
		assertTrue(1 == vbl.listar().size());
	}

	public void testPesquisar() {
		List<ViaturaVO> ls;

		ls = vbl.pesquisar("1234");
		assertEquals(1, ls.size());

		ls = vbl.pesquisar("9999");
		assertEquals(0, ls.size());

	}
}

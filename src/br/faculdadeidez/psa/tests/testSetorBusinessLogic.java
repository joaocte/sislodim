package br.faculdadeidez.psa.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import junit.framework.TestCase;
import br.faculdadeidez.psa.businesslogic.BairroBusinessLogic;
import br.faculdadeidez.psa.businesslogic.SetorBusinessLogic;
import br.faculdadeidez.psa.vo.BairroVO;
import br.faculdadeidez.psa.vo.SetorVO;

/**
 * Classe de teste respons�vel por garantir o funcionamento de SetorBusinessLogic
 */
public class testSetorBusinessLogic extends TestCase{
	/**
	 * Objeto utilizado para garantir os testes 
	 */
	private SetorVO s;
	
	/**
	 * Respos�vel por simular o funcionamento dos testes
	 */
	private SetorBusinessLogic sbl = new SetorBusinessLogic();
	
	/**
	 * Objeto utilizado para garantir os testes 
	 */
	private ArrayList<SetorVO> listSetoresValidos = new ArrayList<SetorVO>();
	
	/**
	 * Objeto utilizado para garantir os testes 
	 */
	private BairroBusinessLogic bbl = new BairroBusinessLogic();
	
	/**
	 * Objeto utilizado para garantir os testes 
	 */
	private Vector<BairroVO> listBairros = (Vector<BairroVO>) bbl.listar();
	
	/**
	 * M�todo para intanciar as propriedades
	 */
	@Override
	protected void setUp() throws Exception {
		this.listSetoresValidos.add(new SetorVO("Setor Tal", true, listBairros));
		this.listSetoresValidos.add(new SetorVO("Outro Setor", true, listBairros));
		this.listSetoresValidos.add(new SetorVO("Setor N Ativo", true, listBairros));
	}
	
	/**
	 * Test case - TC1.1.1 - Valores V�lidos
	 */
	public void testCreateValidos() {
		assertEquals("inserido", sbl.create(this.listSetoresValidos.get(0)));
		assertEquals("inserido", sbl.create(this.listSetoresValidos.get(1)));
		assertEquals("inserido", sbl.create(this.listSetoresValidos.get(2)));
	}
	
	/**
	 * Test case - TC1.1.2 - Valores Nulos
	 */
	public void testCreateNulos() {
		// nome nulo
		s = new SetorVO(null,true, new ArrayList<BairroVO>());
		assertEquals("problemaInserir", sbl.create(s));
		
		// bairros nulos
		s = new SetorVO("Setor teste",true, null);
		assertEquals("problemaInserir", sbl.create(s));
	}
	
	/**
	 * Test case - TC1.1.3 - Valores Existentes
	 */
	public void testCreateValoresExistentes() {
		// nome duplicado
		s = new SetorVO("Setor Tal",true, listBairros);
		assertEquals("setorExistente", sbl.create(s));
	}
	
	/**
	 * Test case - TC1.1.4
	 */
	public void testCreateInvalidos() {
		// nome inv�lido
		// String vazia 
		s = new SetorVO("", true, listBairros);
		assertEquals("O nome n�o foi preenchido", sbl.create(s));

		// nome inv�lido
		// Caracteres especiais 
		s.setNome("@#$%");
		assertEquals("O nome � inv�lido", sbl.create(s));
		
		// nenhum bairro
		s.setNome("Nome Normal");
		s.setBairros(new ArrayList<BairroVO>());
		assertEquals("O setor n�o possui bairros", sbl.create(s));
	}
	

	/**
	 * Testa o m�todo delete do SetorBusinessLogic
	 */
	public void testDelete() {
		List<SetorVO> ls; 
		ls = sbl.pesquisar("Outro Setor");
		assertEquals("removido", sbl.delete(ls.get(0)));
		
		s = new SetorVO(999,"Setor q n existe",true, listBairros);
		assertEquals("setorInexistente", sbl.delete(s));
	}

	/**
	 * Testa o m�todo update do SetorBusinessLogic
	 */
	public void testUpdate() {
		List<SetorVO> ls;

		{
			/**
			 * Test case - TC1.3.1 -> Update com sucesso
			 **/
			ls = sbl.pesquisar("Setor Tal");
			s = ls.get(0);
			//nessa parte vc pode fazer os sets que vc quiser
			assertEquals("atualizado", sbl.update(s));

		}

		{
			/**
			 * Test case - TC1.3.2 ->Setor Inexistente
			 **/
			assertEquals("setorInexistente", sbl.update(new SetorVO("Setor q n existe", false,listBairros)));
		}

		{
			/**
			 * Test case - TC1.3.3 -> Updates com Nulos
			 **/

			ls = sbl.pesquisar("Setor Tal");
			s = ls.get(0);

			// nome nulo
			s.setNome(null);
			assertEquals("problemaAtualizar", sbl.update(s));

			// ativo nulo
			/*s.setNome("Ativo Nulo");
			s.setAtivo(null);
			assertEquals("problemaAtualizar", sbl.update(s));*/
			
			// bairros nulo
			s.setAtivo(true);
			s.setBairros(null);
			assertEquals("problemaAtualizar", sbl.update(s));

		}

		{
			/**
			 * Test case - TC1.3.5 -> Updates Inv�lidos
			 **/
			ls = sbl.pesquisar("Setor Tal");
			s = ls.get(0);
			
			// nome inv�lido
			// String vazia 
			s.setNome("");
			assertEquals("O nome n�o foi preenchido", sbl.update(s));
			
			// nome inv�lido
			// Caracteres especiais 
			s.setNome("@#$%");
			assertEquals("O nome � inv�lido", sbl.update(s));
			
			// nenhum bairro
			s.setNome("Nome Normal");
			s.setBairros(new ArrayList<BairroVO>());
			assertEquals("O setor n�o possui bairros", sbl.update(s));			
		}
	}
	
	/**
	 * Testa os m�todos de listagem do SetorBusinessLogic
	 */
	public void testListar() {
		assertEquals(2, sbl.listarAtivos().size());
		assertEquals(3, sbl.listar().size());
	}
	
	/**
	 * Testa o m�todo pesquisar do SetorBusinessLogic
	 */
	public void testPesquisar() {
		List<SetorVO> ls;
		
		ls = sbl.pesquisar("Setor Tal");
		assertEquals(1, ls.size());

		ls = sbl.pesquisar("Setor que n existe");
		assertEquals(0, ls.size());
	}
	
	public void tearDown()
	{
		//nao exitem metodos qe apaguem os dados do banco
		//truncate as tabelas sis_bairro_setor e sis_setor antes de rodar o teste
	}
}

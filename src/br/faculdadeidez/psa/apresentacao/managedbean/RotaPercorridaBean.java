package br.faculdadeidez.psa.apresentacao.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.faculdadeidez.psa.servico.RetornaEndereco;
import br.faculdadeidez.psa.vo.CoordenadaVO;
import br.faculdadeidez.psa.vo.RotaPercorridaVO;
import br.faculdadeidez.psa.vo.SetorVO;

public class RotaPercorridaBean extends GenericoBean {
	private RotaPercorridaVO rotaPercorrida = new RotaPercorridaVO();
	private SetorVO setorVO = new SetorVO();
	private Date periodoInicio = new Date();
	private Date peridoFim = new Date();
	private Boolean foraDeSetor = false;

	public RotaPercorridaVO getRotaPercorrida() {
		return rotaPercorrida;
	}

	public void setRotaPercorrida(RotaPercorridaVO rotaPercorrida) {
		this.rotaPercorrida = rotaPercorrida;
	}

	public SetorVO getSetorVO() {
		return setorVO;
	}

	public void setSetorVO(SetorVO setorVO) {
		this.setorVO = setorVO;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeridoFim() {
		return peridoFim;
	}

	public void setPeridoFim(Date peridoFim) {
		this.peridoFim = peridoFim;
	}

	public Boolean getForaDeSetor() {
		return foraDeSetor;
	}

	public void setForaDeSetor(Boolean foraDeSetor) {
		this.foraDeSetor = foraDeSetor;
	}

	public List<RotaPercorridaVO> getRotas() {
		if (foraDeSetor) {
			return getRotasForaDeArea();
		}

		List<RotaPercorridaVO> rotas = new ArrayList<RotaPercorridaVO>();
		List<CoordenadaVO> coords = getFachada().listaRotas();

		for (CoordenadaVO coordenadaVO : coords) {
			if ((coordenadaVO.getData().compareTo(peridoFim) >= 0)
					&& (coordenadaVO.getData().compareTo(periodoInicio) < 0)) {
				RotaPercorridaVO rota = new RotaPercorridaVO();

				rota.setBairro(getBairro(coordenadaVO.getLatitude(),
						coordenadaVO.getLongitude()));
				rota.setViatura(coordenadaVO.getViatura());
				rota.setData(coordenadaVO.getData());

				rotas.add(rota);
			}
		}
		return rotas;
	}

	private String getBairro(String latitude, String longitude) {
		RetornaEndereco re = new RetornaEndereco(latitude, longitude);
		return re.getBairro(re.PercorrerXml(re.receberXml()));
	}

	private List<RotaPercorridaVO> getRotasForaDeArea() {
		List<RotaPercorridaVO> rotas = new ArrayList<RotaPercorridaVO>();
		List<CoordenadaVO> coords = getFachada().listaForaDeArea();

		for (CoordenadaVO coordenadaVO : coords) {
			if ((coordenadaVO.getData().compareTo(peridoFim) >= 0)
					&& (coordenadaVO.getData().compareTo(periodoInicio) < 0)) {
				RotaPercorridaVO rota = new RotaPercorridaVO();

				rota.setBairro(getBairro(coordenadaVO.getLatitude(),
						coordenadaVO.getLongitude()));
				rota.setViatura(coordenadaVO.getViatura());
				rota.setData(coordenadaVO.getData());

				rotas.add(rota);
			}
		}

		return rotas;
	}
}

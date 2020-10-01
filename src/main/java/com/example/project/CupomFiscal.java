package com.example.project;

public class CupomFiscal {

	public static String Spacer = System.lineSeparator();

	public static boolean checker (String tested){
		String k = "";
		k += tested;
		if (k.equals("null")|| k.isEmpty()){
			return false;
		}	
		return true;	
	}

	public static String dadosLojaObjeto(Loja loja) {

		if (checker(loja.getNomeLoja()) == false){
			throw new RuntimeException ("O campo nome da loja é obrigatório");
		}

		if (checker(loja.getLogradouro()) == false){
			throw new RuntimeException ("O campo logradouro do endereço é obrigatório");
		}

		String _logradouro = loja.getLogradouro()+ ", ";
		
		String _numero = "0";

		if (loja.getNumero() == 0){
			_numero = "s/n";
		}else{
			_numero = String.format ("%d", loja.getNumero());
		}

		String _complemento = (checker(loja.getComplemento()) == false) ? "" : " " + loja.getComplemento();

		String _bairro = checker(loja.getBairro()) == false ? "" : loja.getBairro() + " - ";

		if (checker(loja.getMunicipio()) == false){
			throw new RuntimeException ("O campo município do endereço é obrigatório");			
		}

		String _municipio = loja.getMunicipio() + " - ";

		if (checker(loja.getEstado()) == false){
			throw new RuntimeException ("O campo estado do endereço é obrigatório");
		}

		String _cep = "";

		if (checker(loja.getCep()) == true){
			_cep = "CEP:" + loja.getCep();
		}

		String _telefone = checker(loja.getTelefone()) == false? "" : "Tel " + loja.getTelefone();

	 	if (!_cep.isEmpty() && !_telefone.isEmpty()){
			_telefone = " Tel " + loja.getTelefone();
		}
		
		String _observacao = checker(loja.getObservacao()) == false ? "" : loja.getObservacao();

		if (checker(loja.getCnpj()) == false){
			throw new RuntimeException ("O campo cnpj da loja é obrigatório");
		}

		String _cnpj = "CNPJ: " + loja.getCnpj();

 	 	if (checker(loja.getInscricaoEstadual()) == false){
			throw new RuntimeException ("O campo inscrição estadual da loja é obrigatório");
		}
		String _inscricao_estadual = "IE: " + loja.getInscricaoEstadual(); 

		return (loja.getNomeLoja() + Spacer +
		 _logradouro + _numero + _complemento + Spacer +
		 _bairro + _municipio + loja.getEstado() + Spacer +
		 _cep + _telefone + Spacer +
		 _observacao + Spacer +	
		 _cnpj + Spacer +
		 _inscricao_estadual + Spacer); 
		
	}

}

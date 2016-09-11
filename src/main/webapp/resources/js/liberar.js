function liberar()
				{
					var situacao = document.getElementById("ass");	
					var valor= document.getElementById("custoUni");
					
					if(situacao.value != "")
					{
						valor.disabled=false;
					}
				}
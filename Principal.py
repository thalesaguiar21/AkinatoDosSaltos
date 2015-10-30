from Predicao import *
from PredicaoDeUmBit import *


testeDeArquivo = PredicaoDeUmBit()
testeDeArquivo.setListaDeSaltos('teste.txt')
testeDeArquivo.predizer()
print(testeDeArquivo.getPorcentagemDeAcertos())
print(testeDeArquivo.getPredicoesFeitas())
print(testeDeArquivo.getListaDeSaltos())


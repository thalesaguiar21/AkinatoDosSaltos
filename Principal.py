from Predicao import *
from PredicaoDeUmBit import *
from PredicaoDeDoisBits import *


testeDeArquivo = PredicaoDeDoisBits()
testeDeArquivo.setListaDeSaltos('teste.txt')
testeDeArquivo.predizer()
print(testeDeArquivo.getPorcentagemDeAcertos())
print(testeDeArquivo.getPredicoesFeitas())
print(testeDeArquivo.getListaDeSaltos())


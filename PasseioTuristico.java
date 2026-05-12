<html>
<head>
<title>PasseioTuristico.java</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.s0 { color: #cf8e6d;}
.s1 { color: #bcbec4;}
.s2 { color: #bcbec4;}
.s3 { color: #6aab73;}
</style>
</head>
<body bgcolor="#191a1c">
<table CELLSPACING=0 CELLPADDING=5 COLS=1 WIDTH="100%" BGCOLOR="#606060" >
<tr><td><center>
<font face="Arial, Helvetica" color="#000000">
PasseioTuristico.java</font>
</center></td></tr></table>
<pre><span class="s0">package </span><span class="s1">modelo</span><span class="s2">;</span>
<span class="s0">import </span><span class="s1">java</span><span class="s2">.</span><span class="s1">time</span><span class="s2">.</span><span class="s1">LocalDateTime</span><span class="s2">;</span>

<span class="s0">public class </span><span class="s1">PasseioTuristico </span><span class="s0">extends  </span><span class="s1">Experiencia</span><span class="s2">{</span>
    <span class="s0">private </span><span class="s1">String pontoDeEncontro</span><span class="s2">;</span>
    <span class="s0">private </span><span class="s1">String guiaResponsável</span><span class="s2">;</span>

    <span class="s0">public </span><span class="s1">PasseioTuristico</span><span class="s2">(</span><span class="s1">String titulo</span><span class="s2">, </span><span class="s1">String descricao</span><span class="s2">, </span><span class="s1">LocalDateTime dataHora</span><span class="s2">, </span><span class="s0">int </span><span class="s1">capacidadeMax</span><span class="s2">, </span><span class="s0">double </span><span class="s1">precoBase</span><span class="s2">, </span><span class="s1">String pontoDeEncontro</span><span class="s2">, </span><span class="s1">String guiaResponsavel</span><span class="s2">){</span>
        <span class="s0">super</span><span class="s2">(</span><span class="s1">titulo</span><span class="s2">, </span><span class="s1">descricao</span><span class="s2">, </span><span class="s1">capacidadeMax</span><span class="s2">,</span><span class="s1">precoBase</span><span class="s2">);</span>
        <span class="s0">this</span><span class="s2">.</span><span class="s1">pontoDeEncontro </span><span class="s2">= </span><span class="s1">pontoDeEncontro</span><span class="s2">;</span>
        <span class="s0">this</span><span class="s2">.</span><span class="s1">guiaResponsável </span><span class="s2">= </span><span class="s1">guiaResponsavel</span><span class="s2">;</span>
    <span class="s2">}</span>

    <span class="s1">@Override</span>
    <span class="s0">public </span><span class="s1">String GerarResumo</span><span class="s2">(){</span>
        <span class="s0">return </span><span class="s1">String</span><span class="s2">.</span><span class="s1">format</span><span class="s2">(</span><span class="s3">&quot;PASSEIO: %s | Encontro: %s | Guia: %s&quot;</span><span class="s2">,</span>
                <span class="s1">getTitulo</span><span class="s2">(), </span><span class="s1">pontoDeEncontro</span><span class="s2">, </span><span class="s1">guiaResponsavel</span><span class="s2">);</span>
    <span class="s2">}</span>
<span class="s2">}</span>


</pre>
</body>
</html>
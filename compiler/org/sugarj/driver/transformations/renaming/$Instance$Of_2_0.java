package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Instance$Of_2_0 extends Strategy 
{ 
  public static $Instance$Of_2_0 instance = new $Instance$Of_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_24, Strategy g_24)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("InstanceOf_2_0");
    Fail137:
    { 
      IStrategoTerm l_125 = null;
      IStrategoTerm j_125 = null;
      IStrategoTerm k_125 = null;
      IStrategoTerm m_125 = null;
      if(term.getTermType() != IStrategoTerm.APPL || renaming._consInstanceOf_2 != ((IStrategoAppl)term).getConstructor())
        break Fail137;
      j_125 = term.getSubterm(0);
      k_125 = term.getSubterm(1);
      IStrategoList annos117 = term.getAnnotations();
      l_125 = annos117;
      term = f_24.invoke(context, j_125);
      if(term == null)
        break Fail137;
      m_125 = term;
      term = g_24.invoke(context, k_125);
      if(term == null)
        break Fail137;
      term = termFactory.annotateTerm(termFactory.makeAppl(renaming._consInstanceOf_2, new IStrategoTerm[]{m_125, term}), checkListAnnos(termFactory, l_125));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
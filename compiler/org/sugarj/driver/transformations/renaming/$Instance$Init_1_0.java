package org.sugarj.driver.transformations.renaming;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class $Instance$Init_1_0 extends Strategy 
{ 
  public static $Instance$Init_1_0 instance = new $Instance$Init_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_18)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("InstanceInit_1_0");
    Fail62:
    { 
      IStrategoTerm d_110 = null;
      IStrategoTerm c_110 = null;
      if(term.getTermType() != IStrategoTerm.APPL || renaming._consInstanceInit_1 != ((IStrategoAppl)term).getConstructor())
        break Fail62;
      c_110 = term.getSubterm(0);
      IStrategoList annos48 = term.getAnnotations();
      d_110 = annos48;
      term = u_18.invoke(context, c_110);
      if(term == null)
        break Fail62;
      term = termFactory.annotateTerm(termFactory.makeAppl(renaming._consInstanceInit_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, d_110));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}
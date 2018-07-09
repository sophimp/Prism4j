package ru.noties.prism4j;

import android.support.annotation.NonNull;

import java.util.List;

public abstract class AbsVisitor implements Prism4j.Visitor {

    @Override
    public void visit(@NonNull List<? extends Prism4j.Node> nodes) {
        for (Prism4j.Node node : nodes) {
            if (node instanceof Prism4j.Syntax) {
                visitSyntax((Prism4j.Syntax) node);
            } else {
                visitText((Prism4j.Text) node);
            }
        }
    }

    protected abstract void visitText(@NonNull Prism4j.Text text);

    // do not forget to call visit(syntax.children()) inside
    protected abstract void visitSyntax(@NonNull Prism4j.Syntax syntax);
}

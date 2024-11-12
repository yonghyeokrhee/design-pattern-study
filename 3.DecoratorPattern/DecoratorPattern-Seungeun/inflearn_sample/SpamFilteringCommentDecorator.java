package inflearn_sample;
import inflearn_sample.CommentDecorator;

public class SpamFilteringCommentDecorator extends CommentDecorator {

    public SpamFilteringCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void writeComment(String comment) {
        if (isNotSpam(comment)) {
            super.writeComment(comment);
        }
    }

    private boolean isNotSpam(String comment) {
        return !comment.contains("http");
    }
}

package inflearn_sample;

public class TrimCommentService extends CommentDecorator {
    private CommentService commentService;

    public TrimCommentService(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void writeComment(String comment) {
        super.writeComment(comment.trim());
    }
}

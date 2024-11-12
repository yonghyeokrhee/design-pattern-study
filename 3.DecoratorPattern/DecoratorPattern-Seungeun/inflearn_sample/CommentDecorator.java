package inflearn_sample;

public class CommentDecorator implements CommentService {
    private CommentService commentService;

    public CommentDecorator(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void writeComment(String comment) {
        commentService.writeComment(comment);
    }
}

package inflearn_sample;

public class Client implements CommentService{
    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void writeComment(String comment) {
        commentService.writeComment(comment);
    }
}

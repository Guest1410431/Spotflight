package tools;

public class MatrixMath 
{
	public static Matrix4f createTransformationMatrix(Vector3f translation, Vector3f rotation, Vector3f scale)
	{
		Matrix4f matrix = new Matrix4f().identity();
		
		matrix.translate(new Vector3f(translation.getX(), translation.getY(), translation.getZ()));
		matrix.rotate(new Vector3f(rotation.getX(), rotation.getY(), rotation.getZ()));
		matrix.scale(new Vector3f(scale.getX(), scale.getY(), scale.getZ()));
		
		return matrix;
	}
}

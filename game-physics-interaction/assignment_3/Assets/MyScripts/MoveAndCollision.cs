using UnityEngine;
using UnityEngine.Rendering;

public class MoveAndCollision : MonoBehaviour
{
    // Start is called once before the first execution of Update after the MonoBehaviour is created

    float speed = 5.0f;
    public float power = 100.0f;
    public GameObject ball;

    void Update()
    {
        float distance_per_frame = speed * Time.deltaTime;
        float vertical_input = Input.GetAxis("Vertical");
        float horizontal_input = Input.GetAxis("Horizontal");

        transform.Translate(Vector3.forward * distance_per_frame * vertical_input);
        transform.Translate(Vector3.right * distance_per_frame * horizontal_input);


        
    }

    void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.name == "Sphere")
        {
            Rigidbody rb = collision.gameObject.GetComponent<Rigidbody>();
            Vector3 launch_Direction = new Vector3(4, 3, 3);

            rb.AddForce(launch_Direction * power);
        }
    }
}
